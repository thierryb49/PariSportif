package org.tune.parisportif.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.tune.parisportif.dto.Parameter;

import lombok.extern.java.Log;

@Log
@Controller
public class ParameterController {
	
	@GetMapping(path = "/parameter")
	public String parameter(Model model) {
		log.info(String.format("parameters"));		
		model.addAttribute("parameter", new Parameter().withUserId(1L).withMatchDay(8L));
		return "parameter";		
	}
	
	@PostMapping(path = "/parameter")
	public String parameterSubmit(@ModelAttribute Parameter parameter) {
		log.info(String.format("parameterSubmit %s", parameter.toString()));		
		return "results";			
	}
	

}
