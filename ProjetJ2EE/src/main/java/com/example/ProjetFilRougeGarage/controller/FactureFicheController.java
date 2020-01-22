package com.example.ProjetFilRougeGarage.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ProjetFilRougeGarage.beans.Devis;
import com.example.ProjetFilRougeGarage.beans.FactureDevis;
import com.example.ProjetFilRougeGarage.beans.FactureFiche;
import com.example.ProjetFilRougeGarage.beans.Fiche;
import com.example.ProjetFilRougeGarage.controller.form.FactureDevisForm;
import com.example.ProjetFilRougeGarage.controller.form.FactureFicheForm;
import com.example.ProjetFilRougeGarage.service.IServiceDevis;
import com.example.ProjetFilRougeGarage.service.IServiceFactureDevis;
import com.example.ProjetFilRougeGarage.service.iServiceFactureFiche;
import com.example.ProjetFilRougeGarage.service.iServiceFiche;

@Controller
public class FactureFicheController {
	@Autowired
	private iServiceFiche serviceFiche;
	@Autowired
	private iServiceFactureFiche serviceFactureFiche;



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

