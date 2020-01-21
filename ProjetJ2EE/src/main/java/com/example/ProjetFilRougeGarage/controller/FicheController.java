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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ProjetFilRougeGarage.beans.Client;
import com.example.ProjetFilRougeGarage.beans.Fiche;
import com.example.ProjetFilRougeGarage.beans.Priorite;
import com.example.ProjetFilRougeGarage.beans.User;
import com.example.ProjetFilRougeGarage.controller.form.FicheForm;
import com.example.ProjetFilRougeGarage.service.IServiceClient;
import com.example.ProjetFilRougeGarage.service.IServicePriorite;
import com.example.ProjetFilRougeGarage.service.iServiceFiche;
import com.example.ProjetFilRougeGarage.service.iServiceUser;

@Controller
public class FicheController {

	@Autowired
	private iServiceFiche servicefiche;
	
	@Autowired
	private IServicePriorite servicepriorite;
	
	@Autowired
	private IServiceClient serviceclient;
	
	@Autowired
	private iServiceUser serviceuser;
	
	private Fiche convertForm(FicheForm ficheform) throws Exception {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date madate1 = sdf.parse(ficheform.getDatecreation());
		Date madate2 = null;
		if (ficheform.getDatecloture().length() > 1) {
		
			madate2 = sdf.parse(ficheform.getDatecloture());
		}
		
		Fiche pfiche = new Fiche();
		
		Client pclient = serviceclient.rechercheClientId(
				Integer.valueOf(ficheform.getClient()));
		
		User puser = serviceuser.rechercherUserId(
				Integer.valueOf(ficheform.getUser()));
		
		Priorite ppriorite = servicepriorite.rechercherPrioriteId(
				Integer.valueOf(ficheform.getPriorite()));
		
		pfiche.setId(ficheform.getId());

		pfiche.setClient(pclient);
		pfiche.setUser(puser);
		pfiche.setPriorite(ppriorite);
		
		pfiche.setDatecreation(madate1);
		pfiche.setDatecloture(madate2);
		pfiche.setEtatfiche(Boolean.valueOf(ficheform.getEtatfiche()));
		pfiche.setDescription(ficheform.getDescription());
		pfiche.setDesactiver(Boolean.valueOf(ficheform.getDesactiver()));

		return pfiche;
	}
	
	
	
	
	@GetMapping("/afficherCreerFiche")
	public String getAffiche(Model pmodel) {
		List<Fiche> lfiche = servicefiche.rechercherFicheActive();
		List<Client> lclient = serviceclient.rechercheClientActive();
		List<User> luser = serviceuser.rechercherUserActive();
		List<Priorite> lpriorite = servicepriorite.rechercherPriorite();
		pmodel.addAttribute("listeclient", lclient);
		pmodel.addAttribute("listeuser", luser);
		pmodel.addAttribute("listepriorite", lpriorite);
		pmodel.addAttribute("listefiche", lfiche);
		pmodel.addAttribute("action", "CreerFiche");
		if(pmodel.containsAttribute("ficheform") == false) {
			FicheForm ficheform = new FicheForm();
			ficheform.setId(0);			
			pmodel.addAttribute("ficheform",ficheform);
		}
		return "fiches";
	}
	
	
	@PostMapping("/CreerFiche")
	public String ajoutFiche( 
			@Valid @ModelAttribute(name = "ficheform") 
			FicheForm ficheform,
			BindingResult presult,
			Model pmodel)
	{
		System.err.println(presult);
		if(!presult.hasErrors()) {
			try
			{
				Fiche pfiche = convertForm(ficheform);
				servicefiche.creerFiche(pfiche);
			}
			catch(Exception e) {
				
				System.err.println(e.getMessage());
			}
		}
		else
		{
			System.err.println(presult);
		}
		return this.getAffiche(pmodel);
	}
	
	
	@GetMapping("/DesactiverFiche/{id}")
	public String getDesativer(@PathVariable final Integer id,Model pmodel) {
		Fiche pfiche = servicefiche.rechercherFicheId(id);
		pfiche.setDesactiver(true);
		servicefiche.desactiverFiche(pfiche);
		return this.getAffiche(pmodel);
	}
	
	
	@GetMapping("/afficherModifierFiche/{id}")
	public String getAfficheMod(@PathVariable final Integer id,Model pmodel) {
		
		Fiche pfiche = servicefiche.rechercherFicheId(id);
		List<Client> lclient = serviceclient.rechercheClient();
		List<User> luser = serviceuser.rechercherUser();
		List<Priorite> lpriorite = servicepriorite.rechercherPriorite();
		
		pmodel.addAttribute("listefiche", null);
		pmodel.addAttribute("listeclient", lclient);
		pmodel.addAttribute("listeuser", luser);
		pmodel.addAttribute("listepriorite", lpriorite);
		pmodel.addAttribute("action", "ModifierFiche");
		
		
		if(pmodel.containsAttribute("ficheform") == false) {
			FicheForm ficheform = new FicheForm();			
			ficheform.setId(pfiche.getId());
			ficheform.setClient(String.valueOf(pfiche.getClient().getId()));
			ficheform.setUser(String.valueOf(pfiche.getUser().getId()));
			ficheform.setEtatfiche(String.valueOf(pfiche.getEtatfiche()));
			ficheform.setPriorite(String.valueOf(pfiche.getPriorite().getId()));
			
			/*
			ficheform.setDatecreation(new SimpleDateFormat("yyyy-MM-dd")
					.format(pfiche.getDatecreation()));
			ficheform.setDatecloture(new SimpleDateFormat("yyyy-MM-dd")
					.format(pfiche.getDatecloture()));
			*/			
			
			if(pfiche.getDatecloture()!=null) {
				ficheform.setDatecloture(pfiche.getDatecloture().toString());
			}
			ficheform.setDatecreation(pfiche.getDatecreation().toString());
			
			ficheform.setDescription(pfiche.getDescription());
			
			pmodel.addAttribute("ficheform", ficheform);
		}
		return "fiches";
	}
	
	@PostMapping("/ModifierFiche")
	public String modifieClasse( 
			@Valid @ModelAttribute(name = "ficheform") 
			FicheForm ficheform,
			 BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Fiche pfiche = convertForm(ficheform);
				servicefiche.modifierFiche(pfiche);
				
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
}
