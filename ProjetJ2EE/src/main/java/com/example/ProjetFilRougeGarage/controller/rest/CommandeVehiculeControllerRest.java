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

import com.example.ProjetFilRougeGarage.beans.CommandeVehicule;
import com.example.ProjetFilRougeGarage.service.IServiceCommandeVehicule;

@RestController
@RequestMapping("/RestCommandeVehicule/")
public class CommandeVehiculeControllerRest {
	@Autowired
	private IServiceCommandeVehicule servicecmdV;
	
	@GetMapping("/RestVehicule")
	public List<CommandeVehicule> getCommandeVehicule(){
		
		return servicecmdV.rechercherCommandeVehiculeActive();
	
	}
	
	@GetMapping("/CommandeVehicule/{id}")
	public CommandeVehicule getCommandeVehicule(@PathVariable("id") int id) {
		return servicecmdV.rechercherCommandeVehiculeId(id);
	}

	@DeleteMapping("/CommandeVehicule/{id}")
	public CommandeVehicule deleteVehicule(@PathVariable("id") int id) {
		CommandeVehicule cmdV = servicecmdV.rechercherCommandeVehiculeId(id);
		servicecmdV.desactiverCommandeVehicule(cmdV);
		return cmdV;
		
	}
	@PutMapping("/CommandeVehicule/{id}")
	public CommandeVehicule updateCommandeVehicule(@PathVariable("id") int id, @RequestBody CommandeVehicule pcmdVehicule){
		CommandeVehicule cp = servicecmdV.rechercherCommandeVehiculeId(id);
		if(cp!=null) {
			servicecmdV.modifierCommandeVehicule(pcmdVehicule);
		}
		return pcmdVehicule;
	}
	
	@PostMapping("/CommandeVehicule")
	public CommandeVehicule addCommandeVehicule(@RequestBody CommandeVehicule pcmdVehicule) {
		servicecmdV.creerCommandeVehicule(pcmdVehicule);
		
		return pcmdVehicule;
	}
}
