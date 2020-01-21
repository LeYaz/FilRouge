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

import com.example.ProjetFilRougeGarage.beans.FactureFiche;
import com.example.ProjetFilRougeGarage.beans.Fiche;
import com.example.ProjetFilRougeGarage.controller.form.FactureFicheForm;
import com.example.ProjetFilRougeGarage.service.iServiceFactureFiche;
import com.example.ProjetFilRougeGarage.service.iServiceFiche;

@Controller
public class FactureFicheController {

	@Autowired
	private iServiceFiche servicefiche;
	@Autowired
	private iServiceFactureFiche servicefacturefiche;
	private FactureFiche convertForm(FactureFicheForm factureficheform) throws Exception {
		
		FactureFiche facturefiche = new FactureFiche();
		facturefiche.setId(factureficheform.getId());
		facturefiche.setFiche(servicefiche.rechercherFicheId(Integer.parseInt(factureficheform.getFiche())));
		facturefiche.setPrixht(Float.valueOf(factureficheform.getPrixht()));
		facturefiche.setTauxTVA(Float.valueOf(factureficheform.getTauxTVA()));
		facturefiche.setDesactiver(Boolean.valueOf(factureficheform.getDesactiver()));
		
		return facturefiche;
	}
	
	@GetMapping("/afficherCreerFactureFiche")
	public String getAffiche(Model pmodel) {
		List<FactureFiche> lfacturefiche = servicefacturefiche.rechercheFactureFicheActive();
		List<Fiche> lfiches = servicefiche.rechercherFicheActive();
		pmodel.addAttribute("listefacturefiche", lfacturefiche);
		pmodel.addAttribute("listefiches", lfiches);
		pmodel.addAttribute("action", "CreerFactureFiche");
		if(pmodel.containsAttribute("factureficheform") == false) {
			FactureFicheForm factureficheform = new FactureFicheForm();
			factureficheform.setId(0);
			pmodel.addAttribute("factureficheform",factureficheform);
		}
		return "facturefiches";
	}
	
	
	@GetMapping("/DesactiverFactureFiche/{id}")
	public String getDesactiver(@PathVariable final Integer id,Model pmodel) {
		FactureFiche facturefiche = servicefacturefiche.rechercheFactureFicheId(id);
		facturefiche.setDesactiver(true);
		servicefacturefiche.desactiverFactureFiche(facturefiche);
		return this.getAffiche(pmodel);
	}
	
	@PostMapping("/CreerFactureFiche")
	public String ajoutFactureFiche( 
			@Valid @ModelAttribute(name = "factureficheform") FactureFicheForm factureficheform,
			BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				FactureFiche facturefiche = convertForm(factureficheform);
				servicefacturefiche.creerFactureFiche(facturefiche);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	
}
