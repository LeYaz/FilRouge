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


import com.example.ProjetFilRougeGarage.beans.Vehicule;
import com.example.ProjetFilRougeGarage.controller.form.VehiculeForm;
import com.example.ProjetFilRougeGarage.service.IServiceVehicule;


/**
 * 
 * @author Xavier
 *
 */
@Controller
public class VehiculeController {
	/*
	 * Déclaration du service
	 */
	@Autowired
	private IServiceVehicule serviceVehicule;


/**
 * Le ConvertForm permet de récupérer le formulaire saisi pour la création
	 * et modification de données
 * @param récupérer le formulaire spécifique a Vehicule
 * @return le formulaire saisi et ses données

 * @throws Exception
 */
	private Vehicule convertForm(VehiculeForm vehiculeform) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date madate = sdf.parse(vehiculeform.getDatecreation());
		Vehicule pvehicule= new Vehicule();
		pvehicule.setId(vehiculeform.getId());
		pvehicule.setModele(vehiculeform.getModele());
		pvehicule.setMarque(vehiculeform.getMarque());
		pvehicule.setQuantite(Integer.valueOf(vehiculeform.getQuantite()));
		pvehicule.setPrixht(Float.valueOf(vehiculeform.getPrixht()));
		pvehicule.setDatecreation(madate);
		pvehicule.setDesactiver(false);
		return pvehicule;
	}
	
	/**
	 * Sert à afficher la liste des vehicule actifs et le formulaire de creation d'un
	 * nouveau vehicule. On les affiche dans la liste
	 * @param pmodel : l'affichage de la page
	 * @return : la page HTML des devis et leur affichage des vehicule
	 */
	@GetMapping("/afficherCreerVehicule")
	public String getAffiche(Model pmodel) {
		List<Vehicule> lvehicule = serviceVehicule.rechercherVehiculeActive();
		pmodel.addAttribute("listevehicule", lvehicule);
		pmodel.addAttribute("action", "CreerVehicule");
		if(!pmodel.containsAttribute("vehiculeform"))
		{
			VehiculeForm vehiculeform = new VehiculeForm();
			vehiculeform.setId(0);
			pmodel.addAttribute("vehiculeform", vehiculeform);
		}
		return "vehicules";
	}
	
	/**
	 * afficher le menu de modification d'un vehicule pour modifier un ou plusieurs 
	 * champs
	 * @param id : l'id du vehicule que l'on souhaite modifier
	 * @param pmodel : l'affichage de la page
	 * @return :  la page HTML des vehicule et leur affichage
	 */
	@GetMapping("/afficherModifierVehicule/{id}")
	public String getAfficheMod(@PathVariable final Integer id, Model pmodel) {
		Vehicule vehicule = serviceVehicule.rechercheVehiculeId(id);
		pmodel.addAttribute("listevehicule", null);
		pmodel.addAttribute("action", "ModifierVehicule");
		if (pmodel.containsAttribute("vehiculeform") == false) {
			VehiculeForm vehiculeform = new VehiculeForm();
			vehiculeform.setId(vehicule.getId());
			vehiculeform.setModele(vehicule.getModele());
			vehiculeform.setMarque(vehicule.getMarque());
			vehiculeform.setQuantite(String.valueOf(vehicule.getQuantite()));
			vehiculeform.setPrixht(String.valueOf(vehicule.getQuantite()));
			vehiculeform.setDatecreation(new SimpleDateFormat("yyyy-MM-dd").format(vehicule.getDatecreation()));
			pmodel.addAttribute("vehiculeform", vehiculeform);
		}
		return "vehicules";
	}
	
	/**
	 * Permet de désactiver un vehicule, le retire de la liste d'affichage mais sans 
	 * l'effacer de la base de données
	 * @param id : l'id du vehicule que l'on veut désactiver
	 * @param pmodel : l'affichage de la liste des vehicules
	 * @return : la liste des vehicules actualisée après la désactivation
	 */
	@GetMapping("/DesactiverVehicule/{id}")
	public String getDesactiver(@PathVariable final Integer id,Model pmodel) {
		Vehicule pvehicule = serviceVehicule.rechercheVehiculeId(id);
		pvehicule.setDesactiver(true);
		serviceVehicule.desactiverVehicule(pvehicule);
		return this.getAffiche(pmodel);
	}
	
	/**
	 * Permet de récupérer ce qui a été envoyer par afficherCreerVehicule, converti le
	 * formulaire et crée le vehicule grace au service
	 * @param vehiculeform : le formulaire du vehicule recupéré
	 * @param presult : le résultat
	 * @param pmodel : l'affichage de la page et des données
	 * @return : l'affichage actualisé avec le vehicule crée
	 * 	 */
	@PostMapping("/CreerVehicule")
	public String ajoutProf(@Valid @ModelAttribute(name="vehiculeform") VehiculeForm vehiculeform, BindingResult presult, Model pmodel) {
		if (!presult.hasErrors()) {
			try {
				Vehicule vehicule = convertForm(vehiculeform);
				serviceVehicule.creerVehicule(vehicule);
				vehiculeform = new VehiculeForm();
				vehiculeform.setId(0);
				pmodel.addAttribute("vehiculeform", vehiculeform);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	/**
	 * Permet de récupérer ce qui a été envoyer par afficherModifierDevis, converti le
	 * formulaire de modification et modifie le vehicule grace au service
	 * @param vehiculeform : le formulaire du vehicule recupéré
	 * @param presult : le résultat
	 * @param pmodel : l'affichage de la page et des données
	 * @return l'affichage actualisé avec le vehicule modifié
	 */
	@PostMapping("/ModifierVehicule")
	public String modifieProf(@Valid @ModelAttribute(name="vehiculeform") VehiculeForm vehiculeform, BindingResult presult, Model pmodel) {
		if (!presult.hasErrors()) {
			try {
				Vehicule vehicule = convertForm(vehiculeform);
				serviceVehicule.modifierVehicule(vehicule);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	
}
