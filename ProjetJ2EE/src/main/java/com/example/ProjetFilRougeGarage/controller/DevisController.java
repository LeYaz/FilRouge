package com.example.ProjetFilRougeGarage.controller;

import java.text.ParseException;
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
import com.example.ProjetFilRougeGarage.beans.Devis;
import com.example.ProjetFilRougeGarage.beans.FactureDevis;
import com.example.ProjetFilRougeGarage.beans.User;
import com.example.ProjetFilRougeGarage.beans.Vehicule;
import com.example.ProjetFilRougeGarage.controller.form.DevisForm;
import com.example.ProjetFilRougeGarage.service.IServiceClient;
import com.example.ProjetFilRougeGarage.service.IServiceDevis;
import com.example.ProjetFilRougeGarage.service.IServiceFactureDevis;
import com.example.ProjetFilRougeGarage.service.IServiceVehicule;
import com.example.ProjetFilRougeGarage.service.ServiceFactureDevis;
import com.example.ProjetFilRougeGarage.service.iServiceUser;


/**
 * 
 * @author Xavier
 * Le controlleur des devis
 *
 */
@Controller
public class DevisController {

	/**
	 * Déclaration des services nécéssaires
	 */
	@Autowired
	private IServiceDevis serviceDevis;
	@Autowired
	private IServiceClient serviceClient;
	@Autowired
	private IServiceVehicule serviceVehicule;
	@Autowired
	private iServiceUser serviceUser;
	@Autowired
	private IServiceFactureDevis factureDevis;

	
	
/**
 * Le ConvertForm permet de récupérer le formulaire saisi pour la création
 * et modification de données
 * @param devisform : récupérer le formulaire spécifique a Devis
 * @return le formulaire saisi et ses données
 * @throws Exception
 */
	
	
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
	
	
	/**
	 * Sert à afficher la liste des devis actifs et le formulaire de creation d'un
	 * nouveau devis. On prend également la liste des client, vehicule, et user 
	 * pour les afficher dans la liste, on passe ensuite à CreerDevis
	 * @param pmodel : l'affichage de la page
	 * @return : la page HTML des devis et leur affichage
	 */
	
	@GetMapping("/afficherCreerDevis")
	public String getAffiche(Model pmodel) {

		List<Client> lclient = serviceClient.rechercheClientActive();
		List<Vehicule> lvehicule = serviceVehicule.rechercherVehiculeActive();
		List<User> luser = serviceUser.rechercherUserActive();
		List<Devis> ldevis = serviceDevis.rechercherDevisActive();
		
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
	
	/**
	 * afficher le menu de modification d'un devis pour modifier un ou plusieurs 
	 * champs
	 * @param id : l'id du devis que l'on souhaite modifier
	 * @param pmodel : l'affichage de la page
	 * @return :  la page HTML des devis et leur affichage
	 */
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
	/**
	 * Permet de récupérer ce qui a été envoyer par afficherCreerDevis, converti le
	 * formulaire et crée le devis grace au service
	 * @param devisform : le formulaire du devis recupéré
	 * @param presult : le résultat
	 * @param pmodel : l'affichage de la page et des données
	 * @return : l'affichage actualisé avec le devis crée
	 * 	 */
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
	
	/**
	 * Permet de récupérer ce qui a été envoyer par afficherModifierDevis, converti le
	 * formulaire de modification et modifie le devis grace au service
	 * @param devisform : le formulaire du devis recupéré
	 * @param presult : le résultat
	 * @param pmodel : l'affichage de la page et des données
	 * @return l'affichage actualisé avec le devis modifié
	 */
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
	/**
	 * Permet de désactiver un devis, le retire de la liste d'affichage mais sans 
	 * l'effacer de la base de données
	 * @param id : l'id du devis que l'on veut désactiver
	 * @param pmodel : l'affichage de la liste des devis
	 * @return : la liste des devis actualisée après la désactivation
	 */
	@GetMapping("/DesactiverDevis/{id}")
	public String getDesactiver(@PathVariable final Integer id,Model pmodel) {
		Devis pdevis = serviceDevis.rechercheDevisId(id);
		pdevis.setDesactiver(true);
		serviceDevis.desactiverDevis(pdevis);
		//pmodel.addAttribute("action", "ModifierPiece");
		
		return this.getAffiche(pmodel);
	}
	

}
