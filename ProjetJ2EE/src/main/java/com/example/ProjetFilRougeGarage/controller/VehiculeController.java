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

import com.example.ProjetFilRougeGarage.beans.Piece;
import com.example.ProjetFilRougeGarage.beans.Vehicule;
import com.example.ProjetFilRougeGarage.controller.form.VehiculeForm;
import com.example.ProjetFilRougeGarage.service.IServiceVehicule;


@Controller
public class VehiculeController {
	@Autowired
	private IServiceVehicule serviceVehicule;

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
		return pvehicule;
	}
	
	@GetMapping("/afficherCreerVehicule")
	public String getAffiche(Model pmodel) {
		List<Vehicule> lvehicule = serviceVehicule.rechercheVehicule();
		pmodel.addAttribute("listevehicule", lvehicule);
		pmodel.addAttribute("action", "CreerVehicule");
		if (pmodel.containsAttribute("vehiculeform") == false) {
			VehiculeForm vehiculeform = new VehiculeForm();
			vehiculeform.setId(0);
			pmodel.addAttribute("vehiculeform", vehiculeform);
		}
		return "vehicules";
	}
	
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
	@GetMapping("/DesactiverVehicule/{id}")
	public String getDesactiver(@PathVariable final Integer id,Model pmodel) {
		Vehicule pvehicule = serviceVehicule.rechercheVehiculeId(id);
		pvehicule.setDesactiver(true);
		serviceVehicule.desactiverVehicule(pvehicule);
		
		return this.getAffiche(pmodel);
	}
	
	
	@PostMapping("/CreerVehicule")
	public String ajoutProf(@Valid @ModelAttribute VehiculeForm vehiculeform, BindingResult presult, Model pmodel) {
		if (!presult.hasErrors()) {
			try {
				Vehicule vehicule = convertForm(vehiculeform);
				serviceVehicule.creerVehicule(vehicule);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	
	@PostMapping("/ModifierVehicule")
	public String modifieProf(@Valid @ModelAttribute VehiculeForm vehiculeform, BindingResult presult, Model pmodel) {
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
