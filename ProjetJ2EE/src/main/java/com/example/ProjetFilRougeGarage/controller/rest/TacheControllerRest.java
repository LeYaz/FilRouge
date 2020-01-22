package com.example.ProjetFilRougeGarage.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetFilRougeGarage.beans.Tache;
import com.example.ProjetFilRougeGarage.service.iServiceTache;

@RestController
@RequestMapping("/RestTache/")
public class TacheControllerRest {
	@Autowired
	private iServiceTache servicetache;
	
	@GetMapping("/Taches")
	public List<Tache> getTaches(){
		return servicetache.rechercheTacheActive();
	}
	
	@GetMapping("/Taches/{id}")
	public Tache getTache(@PathVariable("id") int id){
		return servicetache.rechercherTacheId(id);
	}
	
	@DeleteMapping("/Taches/{id}")
	public Tache deleteTache(@PathVariable("id") int id){
		Tache t = servicetache.rechercherTacheId(id);
		servicetache.desactiverTache(t);;
		return t;
	}
	
	@PutMapping("/Taches/{id}")
	public Tache updateTache(@PathVariable("id") int id, @RequestBody Tache ptache){
		Tache t = servicetache.rechercherTacheId(id);
		if(t!=null) {
			servicetache.modifierTache(t);;
		}
		return ptache;
	}
	
	@PostMapping("/Taches")
	public Tache addTache(@RequestBody Tache ptache) {
		servicetache.creerTache(ptache);
		
		return ptache;
	}
}
