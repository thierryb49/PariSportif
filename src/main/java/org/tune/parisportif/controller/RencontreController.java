package org.tune.parisportif.controller;

import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.TimeZone;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tune.parisportif.entities.Phase;
import org.tune.parisportif.entities.Pronostic;
import org.tune.parisportif.entities.Rencontre;
import org.tune.parisportif.entities.Team;
import org.tune.parisportif.footballdata.ConverterMatch;
import org.tune.parisportif.footballdata.MatchData;
import org.tune.parisportif.repositories.PhaseRepository;
import org.tune.parisportif.repositories.PronosticRepository;
import org.tune.parisportif.repositories.RencontreRepository;
import org.tune.parisportif.repositories.TeamRepository;
import org.tune.parisportif.utils.Utils;

import lombok.extern.java.Log;

@Log
@CrossOrigin("*")
@Controller
public class RencontreController {
	@Autowired
	private RencontreRepository rencontreRepository;	
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private PhaseRepository phaseRepository;
	
	@Autowired
	private PronosticRepository pronosticRepository;
	
	@GetMapping(path = "/api/rencontres")
	public @ResponseBody Collection<Rencontre> getRencontres(@RequestParam(name = "phase_id") Long phaseId) {
		log.info(String.format("PhaseId: %s", phaseId));		
		return rencontreRepository.findAllByPhaseId(phaseId);
	}
	
	@GetMapping(path = "/api/rencontres/load_rencontres")
	public @ResponseBody List<Rencontre> loadRencontres(
			@RequestParam(name = "code_competition") String competitionCode, 
			@RequestParam(name = "matchday") Long matchDay, 
			@RequestParam(name = "phase_id") Long phaseId
			) {
		SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		log.info(String.format("load_rencontres for : competition: %s; matchday: %s; PhaseId: %s;  ", competitionCode, matchDay, phaseId));
		
		//Creation de la phase si elle n'existe pas
		Optional<Phase> oPhase = phaseRepository.findById(phaseId);
		if (!oPhase.isPresent()) {
			phaseRepository.save(new Phase().withId(phaseId).withName(String.format("%s-%s", phaseId, competitionCode)));
		}
		
		List<Rencontre> rencontres = new ArrayList<Rencontre>();		
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(String.format("https://api.football-data.org/v2/competitions/%s/matches/?matchday=%s", competitionCode, matchDay));
		request.addHeader("Content-Type", "application/json");
		request.addHeader("Accept", "application/json");
		request.addHeader("X-Auth-Token", "3b4b9e71c1484492b77d3bfa7684af11");
		
		try {
			HttpResponse response = httpClient.execute(request);
			String reponseJSON = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
			MatchData data = ConverterMatch.fromJsonString(reponseJSON);
			data.getMatches().forEach(match ->{
				Optional<Team> teamDom = teamRepository.findByName(match.getHomeTeam().getName());
				Optional<Team> teamExt = teamRepository.findByName(match.getAwayTeam().getName()); 
				
				if( teamDom.isPresent() &&  teamExt.isPresent()) {
					Optional<Rencontre> rencontre = rencontreRepository.findByPhaseIdAndTeamDomIdAndTeamExtId(phaseId, teamDom.get().getId(), teamExt.get().getId());
						
					if(rencontre.isPresent()) {		
						rencontreRepository.save(rencontre.get()
								.withScoredom(match.getScore().getFullTime().getHomeTeam())
								.withScoreext(match.getScore().getFullTime().getAwayTeam())
								);
					}
					else {
						try {
							rencontres.add(new Rencontre()
									.withPhaseId(phaseId)
									.withTeamDomId(teamDom.get().getId())
									.withTeamExtId(teamExt.get().getId())
									.withScoredom(match.getScore().getFullTime().getHomeTeam())
									.withScoreext(match.getScore().getFullTime().getAwayTeam())
									.withRencontredate(new Timestamp(format.parse(match.getUTCDate()).getTime()))
									);
						} catch (ParseException e) {
							log.info(String.format("loadRencontres ParseException : %s ", e.getMessage()));
						}
					}					
				}
			});
			rencontreRepository.saveAll(rencontres);
		} catch (Exception e) {
			log.info(String.format("loadRencontres Exception : %s ", e.getMessage()));
		}
		
		return rencontres;
	}
	
	
	@GetMapping(path = "/liste_rencontres")
	public String listeRencontres(Model model) {
		log.info(String.format("listeRencontres"));	
		Collection<Pronostic> pronostics = pronosticRepository.pronosticsParPhaseParUser(Utils.getActivePhaseId(), Utils.getUserId());
		Collection<Rencontre> rencontres = rencontreRepository.findAllByPhaseId(Utils.getActivePhaseId());
		/*rencontres.forEach(rencontre->{
			rencontre.setPronostic(pronostics.stream().filter(pronostic->pronostic.getRencontreId().equals(rencontre.getId())).collect(Collectors.toList()));
			//rencontre.setPronostic(pronostics.stream().filter(pronostic->pronostic.getRencontreId().equals(rencontre.getId()).collect(Collectors.toList())));
		});
		*/
		log.info(String.format("listeRencontres: %s", rencontres));	
		model.addAttribute("rencontres", rencontres);
		//model.addAttribute("pronostics", pronosticRepository.findAllByUserId(Utils.getUserId()));
		model.addAttribute("pronostics", pronostics);
		return "rencontres";		
	}
}
