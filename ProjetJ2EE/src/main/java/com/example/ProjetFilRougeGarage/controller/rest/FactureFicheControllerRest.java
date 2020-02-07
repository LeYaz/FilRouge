package com.example.ProjetFilRougeGarage.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetFilRougeGarage.beans.FactureDevis;
import com.example.ProjetFilRougeGarage.beans.FactureFiche;
import com.example.ProjetFilRougeGarage.beans.Fiche;
import com.example.ProjetFilRougeGarage.service.IServiceFactureDevis;
import com.example.ProjetFilRougeGarage.service.iServiceFactureFiche;


/**
 * RestController mapper sur /RestFactureFiche/
 * Permettant d'effectuer un CRUD sur la table FactureFiche
 * @author Xavier
 *
 */
@RestController
@RequestMapping("/RestFactureFiche/")
public class FactureFicheControllerRest {
	@Autowired
	private iServiceFactureFiche servicefiche;
	
	/**
	 * Methode mapper sur /RestFiche/Fiches
	 * @return la liste des fiches au format JSON
	 */
	@GetMapping("/FactureFiches")
	public List<FactureFiche> getFiches(){
		return servicefiche.rechercheFactureFicheActive();
	}
	/**
	 * Methode mapper sur /RestFactureFiche/FactureFiche/{id}
	 * Permettant de recuperer les données d'une fiche
	 * @param id correspond a l'id de la facture de fiches a retourner
	 * @return les données de la facture de fiche au format JSON
	 */
	@GetMapping("/FactureFiches/{id}")
	public FactureFiche getFactureFiche(@PathVariable("id") int id){
		return servicefiche.rechercheFactureFicheId(id);
	}
	
	
}
