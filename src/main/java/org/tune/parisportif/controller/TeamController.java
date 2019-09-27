package org.tune.parisportif.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tune.parisportif.entities.Team;
import org.tune.parisportif.footballdata.ConverterTeam;
import org.tune.parisportif.footballdata.TeamData;
import org.tune.parisportif.repositories.TeamRepository;

import lombok.extern.java.Log;

@Log
@CrossOrigin("*")
@RequestMapping(path = "/api")
@Controller
public class TeamController {
	@Autowired
	private TeamRepository teamRepository;
	
	@GetMapping(path = "/teams/load_teams")
	public @ResponseBody List<Team> loadTeams(@RequestParam(name = "code_competition") String competitionCode) {
		log.info(String.format("load_teams for : %s ", competitionCode));
		List<Team> teams = new ArrayList<Team>();
			
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet("https://api.football-data.org/v2/competitions/" + competitionCode + "/teams");
		request.addHeader("Content-Type", "application/json");
		request.addHeader("Accept", "application/json");
		request.addHeader("X-Auth-Token", "3b4b9e71c1484492b77d3bfa7684af11");
		
		try {
			HttpResponse response = httpClient.execute(request);
			String reponseJSON = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
			log.info(String.format("reponseJSON : %s ", reponseJSON));
			TeamData data = ConverterTeam.fromJsonString(reponseJSON);
			data.getTeams().forEach(team ->{
				//Si la le nom de la team n'existe pas créer l'équipe	
				if(!teamRepository.findByName(team.getName()).isPresent()) {	
					log.info(String.format("Add Team: %s ", team.getName()));
					teams.add(new Team().withName(team.getName()).withFlag(team.getCrestURL()));					
				}
			});
			teamRepository.saveAll(teams);
		} catch (Exception e) {
			log.info(String.format("loadTeams Exception : %s ", e.getMessage()));
		}
		return teams;
	}	
}
