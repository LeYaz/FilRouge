package com.example.ProjetFilRougeGarage.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetFilRougeGarage.beans.Vehicule;
import com.example.ProjetFilRougeGarage.service.IServiceVehicule;

/**
 * RestController mapper sur /RestVehicule/
 * Permettant d'effectuer un CRUD sur la table vehicule
 * 
 * @author Teddy
 *
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/RestVehicule")
public class VehiculeControllerRest {
	
	@Autowired
	private IServiceVehicule servicevehicule;
	
	
	/**
	 * Methode mapper sur /RestVehicule/Vehicules
	 * 
	 * @return la liste des vehicules au format JSON
	 */
	@GetMapping("/Vehicules")
	public List<Vehicule> getVehicules(){
		return servicevehicule.rechercherVehiculeActive();
	}
	
	/**
	 * Methode mapper sur /RestVehicules/{id}
	 * permettant de recuperer les données d'une pièce
	 * @param id correspond  l'id du vehicule a retourner
	 * @return les données d'un vehicule au format JSON
	 */
	@GetMapping("/Vehicules/{id}")
	public Vehicule getVehicule(@PathVariable("id") int id) {
		return servicevehicule.rechercheVehiculeId(id);
	}
	
	/**
	 * Methode mapper sur /RestVehicule/Vehicules/{id}
	 * permettant de desactiver un vehicule
	 * @param id correspond a l'id du vehicule a desactiver
	 * @return les données de la pieces désactiver au format JSON
	 */
	@DeleteMapping("/Vehicules/{id}")
	public Vehicule deleteVehicule(@PathVariable("id") int id) {
		Vehicule v = servicevehicule.rechercheVehiculeId(id);
		servicevehicule.desactiverVehicule(v);
		return v;
	}
	
	/**
	 * Methode mapper sur /RestVehicule/Vehicules/{id}
	 * permettant de mettre a jour un vehicule
	 * @param id correspond a l'id de la piece a mettre a jour
	 * @param vvehicule au données de la piece a mettre a jour
	 * @return le vehicule avec ses données mise a jour
	 */
	@PutMapping("/Vehicules/{id}")
	public Vehicule updateVehicule(@PathVariable("id") int id, @RequestBody Vehicule vvehicule) {
		Vehicule v = servicevehicule.rechercheVehiculeId(id);
		if(v!=null) {
			servicevehicule.modifierVehicule(vvehicule);
		}
		return vvehicule;
	}
	
	/**
	 * methode mapper sur /RestVehicule/Vehicules
	 * permettant d'ajouter un vehicule en bdd
	 * @param vvehicule correspond au données du vehicule
	 * @return le vehicule ajoute en bdd
	 */
	@PostMapping("/Vehicules")
	public  Vehicule addVehicule(@RequestBody Vehicule vvehicule) {
		servicevehicule.creerVehicule(vvehicule);
		return vvehicule;
	}	

}
