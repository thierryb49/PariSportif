package org.tune.parisportif.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tune.parisportif.entities.Pronostic;
import org.tune.parisportif.entities.Rencontre;
import org.tune.parisportif.repositories.PronosticRepository;
import org.tune.parisportif.repositories.RencontreRepository;
import org.tune.parisportif.utils.Utils;

import lombok.extern.java.Log;

@Log
@Controller
public class PronosticController {
	
	@Autowired
	PronosticRepository pronosticRepository;
	
	@Autowired
	RencontreRepository rencontreRepository;
	
	@GetMapping(path = "/pronostic")
	public String pronostic(@RequestParam(name = "rid") Long rencontreId, Model model) {
		log.info(String.format("pronostic"));	
		Optional<Rencontre> oRencontre = rencontreRepository.findById(rencontreId);
		
		Optional<Pronostic> oPronostic = pronosticRepository.findByUserIdAndRencontreId(Utils.getUserId(), rencontreId);
		Pronostic pronostic = (oPronostic.isPresent()) ? oPronostic.get() : pronosticRepository.save(new Pronostic()
				.withRencontreId(rencontreId)
				.withUserId(Utils.getUserId())
				.withScoreDom(0L)
				.withScoreExt(0L)) ;
		model.addAttribute("pronostic", pronostic);
		model.addAttribute("rencontre", oRencontre.get());
		return "pronostic";		
	}
	
	@PostMapping(path = "/pronostic")
	public String updatePronostic(@ModelAttribute Pronostic pronostic, Model model) {
		log.info(String.format("updatePronostic: %s", pronostic));		
		Optional<Rencontre> oRencontre = rencontreRepository.findById(pronostic.getRencontreId());
		Optional<Pronostic> oPronostic = pronosticRepository.findByUserIdAndRencontreId(Utils.getUserId(), pronostic.getRencontreId());
		
		if(oPronostic.isPresent()) {
			pronosticRepository.save(oPronostic.get()
					.withScoreDom(pronostic.getScoreDom())
					.withScoreExt(pronostic.getScoreExt())
					);
		}
		else {
			pronosticRepository.save(pronostic
					.withUserId(Utils.getUserId())
					);
		}
		model.addAttribute("pronostic", pronostic);
		model.addAttribute("rencontre", oRencontre.get());
		return "pronostic";		
	}
}
