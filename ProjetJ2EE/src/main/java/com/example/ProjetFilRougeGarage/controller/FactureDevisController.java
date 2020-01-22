package com.example.ProjetFilRougeGarage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ProjetFilRougeGarage.beans.Devis;
import com.example.ProjetFilRougeGarage.beans.FactureDevis;
import com.example.ProjetFilRougeGarage.controller.form.FactureDevisForm;
import com.example.ProjetFilRougeGarage.service.IServiceDevis;
import com.example.ProjetFilRougeGarage.service.IServiceFactureDevis;

@Controller
public class FactureDevisController {
	@Autowired
	private IServiceDevis serviceDevis;
	@Autowired
	private IServiceFactureDevis serviceFactureDevis;

	

	

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
	

}
