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

import com.example.ProjetFilRougeGarage.beans.Fiche;
import com.example.ProjetFilRougeGarage.service.iServiceFiche;
/**
 * RestController mapper sur /RestFiche/
 * Permettant d'effectuer un CRUD sur la table piece
 * @author Yazid
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/RestFiche/")
public class FicheControllerRest {
	@Autowired
	private iServiceFiche servicefiche;
	
	/**
	 * Methode mapper sur /RestFiche/Fiches
	 * @return la liste des fiches au format JSON
	 */
	@GetMapping("/Fiches")
	public List<Fiche> getFiches(){
		return servicefiche.rechercherFicheActive();
	}
	
	/**
	 * Methode mapper sur /RestFiche/Fiches/{id}
	 * Permettant de recuperer les données d'une fiche
	 * @param id correspond a l'id de la fiche a retourner
	 * @return les données de la fiche au format JSON
	 */
	@GetMapping("/Fiches/{id}")
	public Fiche getFiche(@PathVariable("id") int id){
		return servicefiche.rechercherFicheId(id);
	}
	
	
	/**
	 * Methode mapper sur /RestFiche/Fiches/{id}
	 * Permettant de desactiver une fiche
	 * @param id correspond à l'id de la fiche a desactiver
	 * @return Les données de la fiche desactiver au format JSON
	 */
	@DeleteMapping("/Fiches/{id}")
	public Fiche deleteFiche(@PathVariable("id") int id){
		Fiche f = servicefiche.rechercherFicheId(id);
		servicefiche.desactiverFiche(f);;
		return f;
	}
	
	/**
	 * Methode mapper sur /RestFiche/Fiches/{id}
	 * Permettant de mettre a jour une fiche
	 * @param id correspond à l'id de la fiche a mettre a jour
	 * @param pfiche objet contenant données de la fiche a mettre a jour
	 * @return la fiche avec ses données mise a jour au format JSON
	 */
	@PutMapping("/Fiches/{id}")
	public Fiche updateFiche(@PathVariable("id") int id, @RequestBody Fiche pfiche){
		Fiche f = servicefiche.rechercherFicheId(id);
		if(f!=null) {
			servicefiche.modifierFiche(pfiche);
		}
		return pfiche;
	}
	
	/**
	 * Methode mapper sur /RestFiche/Fiches/
	 * Permettant d'ajouter une Fiche en bdd
	 * @param pfiche correpond au données de la Fiche
	 * @return La fiche ajouter en bdd
	 */
	@PostMapping("/Fiches")
	public Fiche addFiche(@RequestBody Fiche pfiche) {
		servicefiche.creerFiche(pfiche);
		
		return pfiche;
	}
}
