package com.example.ProjetFilRougeGarage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ProjetFilRougeGarage.beans.Client;
import com.example.ProjetFilRougeGarage.beans.Devis;
import com.example.ProjetFilRougeGarage.beans.FactureDevis;
import com.example.ProjetFilRougeGarage.beans.User;
import com.example.ProjetFilRougeGarage.beans.Vehicule;
import com.example.ProjetFilRougeGarage.controller.form.DevisForm;
import com.example.ProjetFilRougeGarage.controller.form.FactureDevisForm;
import com.example.ProjetFilRougeGarage.service.IServiceDevis;
import com.example.ProjetFilRougeGarage.service.IServiceFactureDevis;

@Controller
public class FactureDevisController {
	@Autowired
	private IServiceDevis serviceDevis;
	@Autowired
	private IServiceFactureDevis serviceFactureDevis;

	
	private FactureDevis convertForm(FactureDevisForm facturedevisform) throws Exception {
		FactureDevis pfacturedevis = new FactureDevis();
		/**
		 * Récupérer les bons ID des clients des vehicules et des User
		 */
		Devis idDevis= serviceDevis.rechercheDevisId(Integer.valueOf(facturedevisform.getDevis()));

		pfacturedevis.setId(facturedevisform.getId());
		pfacturedevis.setDevis(idDevis);
		pfacturedevis.setPrixht(Float.valueOf(idDevis.getVehicule().getPrixht()));
		pfacturedevis.setTauxtva(Float.valueOf(0.20F));
		pfacturedevis.setDatecreation(idDevis.getDatecreation());
		pfacturedevis.setDesactiver(Boolean.valueOf(facturedevisform.getDesactiver()));
		
		return pfacturedevis;
	}
	

	@GetMapping("/afficherCreerFactureDevis")
	public String getAffiche(Model pmodel) {

		List<Devis> ldevis = serviceDevis.rechercherDevisActive();
		List<FactureDevis> lfacturedevis = serviceFactureDevis.rechercherFactureDevisActive();

		pmodel.addAttribute("listedevis", ldevis);
		pmodel.addAttribute("listefacturedevis", lfacturedevis);

		pmodel.addAttribute("action", "CreerFactureDevis");
		if (pmodel.containsAttribute("facturedevisform") == false) {
			FactureDevisForm facturedevisform = new FactureDevisForm();
			facturedevisform.setId(0);
			pmodel.addAttribute("facturedevisform", facturedevisform);
		}
		return "facturedevis";
	}
	
	@PostMapping("/CreerFactureDevis")
	public String ajoutNote(@Valid @ModelAttribute(name = "facturedevisform") FactureDevisForm facturedevisform, BindingResult presult,
			Model pmodel) {
		System.err.println(presult);
		if (!presult.hasErrors()) {
			try {
				FactureDevis pfacturedevis = convertForm(facturedevisform);
				serviceFactureDevis.creerFactureDevis(pfacturedevis);
				
			} catch (Exception e) {
				System.err.println("CRDeVis :"+e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
}
