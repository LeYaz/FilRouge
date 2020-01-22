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

import com.example.ProjetFilRougeGarage.beans.CommandeVehicule;
import com.example.ProjetFilRougeGarage.beans.Devis;
import com.example.ProjetFilRougeGarage.controller.form.CommandeVehiculeForm;
import com.example.ProjetFilRougeGarage.service.IServiceCommandeVehicule;
import com.example.ProjetFilRougeGarage.service.IServiceDevis;

@Controller
public class CommandeVehiculeController {
	@Autowired
	private IServiceCommandeVehicule servicecmdvehicule;

	@Autowired
	private IServiceDevis servicedevis;

	private CommandeVehicule convertForm(CommandeVehiculeForm commandevehiculeform) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date datecreation = sdf.parse(commandevehiculeform.getDate_creation());
		Date datecloture = null;
		if (commandevehiculeform.getDate_cloture().length() > 1) {
			datecloture = sdf.parse(commandevehiculeform.getDate_cloture());
		}

		CommandeVehicule comv = new CommandeVehicule();

		comv.setId(commandevehiculeform.getId());
		comv.setDatecloture(datecloture);
		comv.setDatecreation(datecreation);
		comv.setDesactiver(false);
		comv.setDevis(servicedevis.rechercheDevisId(Integer.valueOf(commandevehiculeform.getDevis())));
		comv.setEtat(Boolean.valueOf(commandevehiculeform.getEtat()));

		return comv;
	}

	@GetMapping("/afficherCreerCommandeVehicule")
	public String getAffiche(Model pmodel) {
		List<CommandeVehicule> lcommandevehicule = servicecmdvehicule.rechercherCommandeVehiculeActive();
		List<Devis> ldevis = servicedevis.rechercherDevisActive();

		pmodel.addAttribute("listecommandevehicule", lcommandevehicule);
		pmodel.addAttribute("listedevis", ldevis);

		pmodel.addAttribute("action", "CreerCommandeVehicule");
		if (!pmodel.containsAttribute("commandevehiculeform")) {
			CommandeVehiculeForm commandevehiculeform = new CommandeVehiculeForm();
			commandevehiculeform.setId(0);
			pmodel.addAttribute("commandevehiculeform", commandevehiculeform);
		}
		return "commandevehicules";
	}

	@GetMapping("/afficherModifierCommandeVehicule/{id}")
	public String getAfficheMod(@PathVariable final Integer id, Model pmodel) {
		CommandeVehicule vcommande = servicecmdvehicule.rechercherCommandeVehiculeId(id);
		List<Devis> ldevis = servicedevis.rechercherDevisActive();

		pmodel.addAttribute("listecommandevehicule", null);
		pmodel.addAttribute("listedevis", ldevis);
		pmodel.addAttribute("action", "ModifierCommandeVehicule");
		if (pmodel.containsAttribute("commandevehiculeform") == false) {
			CommandeVehiculeForm commandevehiculeform = new CommandeVehiculeForm();
			commandevehiculeform.setId(vcommande.getId());

			if (commandevehiculeform.getDate_cloture() != null) {
				commandevehiculeform.setDate_cloture(vcommande.getDatecloture().toString());
			}

			commandevehiculeform.setDate_creation(vcommande.getDatecreation().toString());
			commandevehiculeform.setDesactiver(vcommande.getDesactiver().toString());
			commandevehiculeform.setDevis(vcommande.getDevis().getId().toString());
			commandevehiculeform.setEtat(vcommande.getEtat().toString());

			pmodel.addAttribute("commandevehiculeform", commandevehiculeform);
		}
		return "commandevehicules";
	}

	@GetMapping("/DesactiverCommandeVehicule/{id}")
	public String getDesactiver(@PathVariable final Integer id, Model pmodel) {
		CommandeVehicule vcommande = servicecmdvehicule.rechercherCommandeVehiculeId(id);
		if (vcommande != null) {
			servicecmdvehicule.desactiverCommandeVehicule(vcommande);
		}
		return this.getAffiche(pmodel);
	}

	@PostMapping("/CreerCommandeVehicule")
	public String ajoutUser(
			@Valid @ModelAttribute(name = "commandevehiculeform") CommandeVehiculeForm commandevehiculeform,
			BindingResult presult, Model pmodel) {
		System.err.println(presult);
		if (!presult.hasErrors()) {
			try {
				CommandeVehicule commande = convertForm(commandevehiculeform);
				commandevehiculeform = new CommandeVehiculeForm();
				commandevehiculeform.setId(0);
				pmodel.addAttribute("commandevehiculeform", commandevehiculeform);
				servicecmdvehicule.creerCommandeVehicule(commande);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}

	@PostMapping("/ModifierCommandeVehicule")
	public String modifieUser(@Valid @ModelAttribute CommandeVehiculeForm commandevehiculeform, BindingResult presult,
			Model pmodel) {
		if (!presult.hasErrors()) {
			try {
				CommandeVehicule commande = convertForm(commandevehiculeform);
				servicecmdvehicule.modifierCommandeVehicule(commande);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}

}
