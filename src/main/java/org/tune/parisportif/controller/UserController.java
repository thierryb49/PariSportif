package org.tune.parisportif.controller;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tune.parisportif.entities.Pronostic;
import org.tune.parisportif.entities.Rencontre;
import org.tune.parisportif.entities.User;
import org.tune.parisportif.repositories.PronosticRepository;
import org.tune.parisportif.repositories.RencontreRepository;
import org.tune.parisportif.repositories.UserRepository;

import lombok.extern.java.Log;

@Log
@Controller
@CrossOrigin("*")
@RequestMapping(path = "/api")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PronosticRepository pronosticRepository;
	
	@Autowired
	private RencontreRepository rencontreRepository;
	
	@GetMapping(path = "/users/signin")
	public @ResponseBody User signin(@RequestParam String username, @RequestParam String password) {
		log.info(String.format("Tentative de connexion: %s / %s ", username, password));
		Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
		return user.isPresent() ? user.get() : null;
	}
	
	@GetMapping(path = "/users/create_user")
	public @ResponseBody User createUser(@RequestParam String username, @RequestParam String password, @RequestParam String mail) {
		log.info(String.format("Create user: %s / %s / %s", username, password, mail));
		User user = null;
		if(!userRepository.findByUsername(username).isPresent() || !userRepository.findByMail(mail).isPresent()) {
			user =  userRepository.save(new User().withUsername(username).withPassword(password).withMail(mail));
			log.info(String.format("Create user: [ %s ] ::  %s / %s / %s", user.getId(), user.getUsername(), user.getPassword(), user.getMail()));
		}		
		return user;		
	}
	
	@GetMapping(path = "/users/create_or_update_pronostic")
	public @ResponseBody Pronostic createOrUpdatePronostic(
			@RequestParam(name = "uid") Long userId, 
			@RequestParam(name = "rid") Long rencontreId, 
			@RequestParam(name = "scd") Long scoreDom, 
			@RequestParam(name = "sce") Long scoreExt, 
			@RequestParam(name = "pid", required = false) Long pronoId
			) {
		
		log.info(String.format("CreateOrUpdatePronostic: %s / %s / %s / %s / %s", userId, rencontreId, scoreDom, scoreExt, pronoId));
		
		
		Optional<User> oUser = userRepository.findById(userId);
		Optional<Rencontre> oRencontre = rencontreRepository.findById(rencontreId);
		Pronostic pronostic = null;
		
		//Verifier si le User existe et la rencontre existe
		if(oUser.isPresent() && oRencontre.isPresent()) {
			//Checker si la rencontre est ouvert au pronostic
			if(oRencontre.get().getRencontredate() != null && oRencontre.get().getRencontredate().compareTo(Calendar.getInstance().getTime()) > 0 ) {
				return null;
			}
			//Create or update Pronostic
			Optional<Pronostic> oPronostic = pronosticRepository.findByUserIdAndRencontreId(userId, rencontreId);			
			//Si un Pronostic existe déjà pour cet utilisateur et cette rencontre
			if(oPronostic.isPresent()) {
				//Create
				if(pronoId == null) {
					log.info(String.format("Create Pronostic"));
					pronostic = pronosticRepository.save(new Pronostic().withUserId(userId).withRencontreId(rencontreId).withScoreDom(scoreDom).withScoreExt(scoreExt));
				}
				
				//Update si l'id passé en paramètre correspond à celui trouvé base
				if(pronoId != null && pronoId.equals(oPronostic.get().getId())) {
					log.info(String.format("Update Pronostic: %s ", pronoId));
					pronostic = pronosticRepository.save(oPronostic.get().withUserId(userId).withRencontreId(rencontreId).withScoreDom(scoreDom).withScoreExt(scoreExt));
				}				
			}						
		}
		return pronostic;
	}
	
	@GetMapping(path = "/users/get_pronostics")
	public @ResponseBody Collection<Pronostic> getPronostics(@RequestParam(name = "uid") Long userId) {		
		return pronosticRepository.findAllByUserId(userId);			
	}
	
	@GetMapping(path = "/users/get_classement")
	public @ResponseBody Map<User, Long> getClassement() {
		
		 Map<User,Long> classement=new HashMap<User,Long>();
		 
		 classement.put(new User().withId(1L).withUsername("Thierry").withMail("thierry_bouillon@hotmail.com").withPassword("TBO"), 10L);
		 classement.put(new User().withId(2L).withUsername("Julien").withMail("juju@hotmail.com").withPassword("JSE"), 50L);
		 classement.put(new User().withId(3L).withUsername("Abdel").withMail("abdel@hotmail.com").withPassword("ABA"), 45L);
		 //Elements can traverse in any order  
		 /*for(Map.Entry m:classement.entrySet()){  
		   System.out.println(m.getKey()+" "+m.getValue());  
		 }*/  
		 
		 
		return classement;
	}
}
