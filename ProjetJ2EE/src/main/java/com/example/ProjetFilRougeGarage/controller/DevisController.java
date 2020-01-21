package com.example.ProjetFilRougeGarage.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.example.ProjetFilRougeGarage.beans.Devis;
import com.example.ProjetFilRougeGarage.beans.Piece;
import com.example.ProjetFilRougeGarage.beans.User;
import com.example.ProjetFilRougeGarage.beans.Vehicule;
import com.example.ProjetFilRougeGarage.controller.form.DevisForm;
import com.example.ProjetFilRougeGarage.service.IServiceClient;
import com.example.ProjetFilRougeGarage.service.IServiceDevis;
import com.example.ProjetFilRougeGarage.service.IServiceVehicule;
import com.example.ProjetFilRougeGarage.service.iServiceUser;

@Controller
public class DevisController {

	@Autowired
	private IServiceDevis serviceDevis;
	@Autowired
	private IServiceClient serviceClient;
	@Autowired
	private IServiceVehicule serviceVehicule;
	@Autowired
	private iServiceUser serviceUser;
	
	
	private Devis convertForm(DevisForm devisform) throws Exception {
		Devis pdevis = new Devis();
		//System.err.println(devisform.getClient());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date madate = sdf.parse(devisform.getDatecreation());
		System.err.println("devisform"+devisform.getId());
		/**
		 * Récupérer les bons ID des clients des vehicules et des User
		 */
		Client idClient= serviceClient.rechercheClientId(Integer.valueOf(devisform.getClient()));
		Vehicule idVehicule= serviceVehicule.rechercheVehiculeId(Integer.valueOf(devisform.getVehicule()));
		User idUser= serviceUser.rechercherUserId(Integer.valueOf(devisform.getUser()));

		pdevis.setId(devisform.getId());
		pdevis.setClient(idClient);
		pdevis.setVehicule(idVehicule);
		pdevis.setUser(idUser);
		pdevis.setDatecreation(madate);
		pdevis.setEtatdevis(Boolean.valueOf(devisform.getEtatdevis()));
		pdevis.setDesactiver(Boolean.valueOf(devisform.getDesactiver()));

		return pdevis;
	}
	
	@GetMapping("/afficherCreerDevis")
	public String getAffiche(Model pmodel) {

		List<Client> lclient = serviceClient.rechercheClient();
		List<Vehicule> lvehicule = serviceVehicule.rechercheVehicule();
		List<User> luser = serviceUser.rechercherUser();
		List<Devis> ldevis = serviceDevis.rechercheDevis();

		pmodel.addAttribute("listeclient", lclient);
		pmodel.addAttribute("listevehicule", lvehicule);
		pmodel.addAttribute("listeuser", luser);
		pmodel.addAttribute("listedevis", ldevis);

		pmodel.addAttribute("action", "CreerDevis");
		if (pmodel.containsAttribute("devisform") == false) {
			DevisForm devisform = new DevisForm();
			devisform.setId(0);
			pmodel.addAttribute("devisform", devisform);
		}
		return "devis";
	}
	
	@GetMapping("/afficherModifierDevis/{id}")
	public String getAfficheMod(@PathVariable final Integer id, Model pmodel) {
		Devis pdevis = serviceDevis.rechercheDevisId(id);
		List<Client> lclient = serviceClient.rechercheClient();
		List<Vehicule> lvehicule = serviceVehicule.rechercheVehicule();
		List<User> luser = serviceUser.rechercherUser();
		List<Devis> ldevis = serviceDevis.rechercheDevis();

		pmodel.addAttribute("listeclient", lclient);
		pmodel.addAttribute("listevehicule", lvehicule);
		pmodel.addAttribute("listeuser", luser);
		pmodel.addAttribute("listedevis", ldevis);
		pmodel.addAttribute("action", "ModifierDevis");
		if (pmodel.containsAttribute("devisform") == false) {
			DevisForm devisform = new DevisForm();
			devisform.setId(pdevis.getId());
			devisform.setDatecreation(pdevis.getDatecreation().toString());
			devisform.setClient(String.valueOf(pdevis.getClient().getId()));
			devisform.setVehicule(String.valueOf(pdevis.getVehicule().getId()));
			devisform.setUser(String.valueOf(pdevis.getUser().getId()));
			devisform.setEtatdevis(String.valueOf(pdevis.getEtatdevis()));

			pmodel.addAttribute("devisform", devisform);
		}
		return "devis";
	}
	
	@PostMapping("/CreerDevis")
	public String ajoutNote(@Valid @ModelAttribute(name = "devisform") DevisForm devisform, BindingResult presult,
			Model pmodel) {
		System.err.println(presult);
		if (!presult.hasErrors()) {
			try {
				Devis pdevis = convertForm(devisform);
				System.err.println("convert");
				serviceDevis.creerDevis(pdevis);
				
			} catch (Exception e) {
				System.err.println("CRDeVis :"+e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	
	@PostMapping("/ModifierDevis")
	public String modifieNote(@Valid @ModelAttribute(name = "devisform") DevisForm devisform, BindingResult presult,
			Model pmodel) {
		System.err.println(presult);
		if (!presult.hasErrors()) {
			try {

				Devis pdevis = convertForm(devisform);
				serviceDevis.modifierDevis(pdevis);

			} catch (Exception e) {
				System.err.println("MODDeVis :"+e.getMessage());
			}
		}
		return this.getAffiche(pmodel);

	}
	
	@GetMapping("/DesactiverDevis/{id}")
	public String getDesactiver(@PathVariable final Integer id,Model pmodel) {
		Devis pdevis = serviceDevis.rechercheDevisId(id);
		pdevis.setDesactiver(true);
		serviceDevis.desactiverDevis(pdevis);
		//pmodel.addAttribute("action", "ModifierPiece");
		
		return this.getAffiche(pmodel);
	}
	

}
