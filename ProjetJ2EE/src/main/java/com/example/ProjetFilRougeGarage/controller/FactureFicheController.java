package com.example.ProjetFilRougeGarage.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.ProjetFilRougeGarage.beans.FactureFiche;
import com.example.ProjetFilRougeGarage.beans.Fiche;
import com.example.ProjetFilRougeGarage.controller.form.FactureFicheForm;
import com.example.ProjetFilRougeGarage.service.iServiceFactureFiche;
import com.example.ProjetFilRougeGarage.service.iServiceFiche;

/**
 * 
 * @author Xavier
 *
 */
@Controller
public class FactureFicheController {
	/**
	 * Déclaration des services
	 */
	@Autowired
	private iServiceFiche serviceFiche;
	@Autowired
	private iServiceFactureFiche serviceFactureFiche;


	/**
	 * Affiche la liste des facture de fiches actives
	 * @param pmodel : l'affichage des données
	 * @return la page html des facture de fiches avec sa liste.
	 */
	@GetMapping("/afficherCreerFactureFiche")
	public String getAffiche(Model pmodel) {

		List<Fiche> lfiche = serviceFiche.rechercherFicheActive();
		List<FactureFiche> lfacturefiche = serviceFactureFiche.rechercheFactureFicheActive();

		pmodel.addAttribute("listefiche", lfiche);
		pmodel.addAttribute("listefacturefiche", lfacturefiche);

		pmodel.addAttribute("action", "CreerFactureFiche");
		if (pmodel.containsAttribute("factureficheform") == false) {
			FactureFicheForm factureficheform = new FactureFicheForm();
			factureficheform.setId(0);
			pmodel.addAttribute("factureficheform", factureficheform);
		}
		
		
		return "facturefiches";
	}
	

}

