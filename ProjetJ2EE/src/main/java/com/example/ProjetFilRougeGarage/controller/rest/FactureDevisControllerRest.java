package com.example.ProjetFilRougeGarage.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetFilRougeGarage.beans.FactureDevis;
import com.example.ProjetFilRougeGarage.service.IServiceFactureDevis;


/**
 * RestController mapper sur /RestFacture/
 * Permettant d'effectuer un CRUD sur la table FactureDevis
 * @author Xavier
 *
 */
@RestController
@RequestMapping("/RestFactureDevis/")
public class FactureDevisControllerRest {
	@Autowired
	private IServiceFactureDevis servicedevis;
	
	/**
	 * Methode mapper sur /RestFactureDevis
	 * @return la liste des devis au format JSON
	 */
	@GetMapping("/FactureDevis")
	public List<FactureDevis> getDevis(){
		return servicedevis.rechercherFactureDevisActive();
	}
	/**
	 * Methode mapper sur /RestFactureDevis/FactureDevis/{id}
	 * Permettant de recuperer les données d'un devis
	 * @param id correspond a l'id de la facture de devis a retourner
	 * @return les données de la facture de devis au format JSON
	 */
	@GetMapping("/FactureDevis/{id}")
	public FactureDevis getFactureDevis(@PathVariable("id") int id){
		return servicedevis.rechercheFactureDevisId(id);
	}
	
	
}
