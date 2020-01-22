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

import com.example.ProjetFilRougeGarage.beans.Fiche;
import com.example.ProjetFilRougeGarage.beans.Piece;
import com.example.ProjetFilRougeGarage.beans.Priorite;
import com.example.ProjetFilRougeGarage.beans.Tache;
import com.example.ProjetFilRougeGarage.beans.User;
import com.example.ProjetFilRougeGarage.controller.form.TacheForm;
import com.example.ProjetFilRougeGarage.service.IServicePriorite;
import com.example.ProjetFilRougeGarage.service.iServiceFiche;
import com.example.ProjetFilRougeGarage.service.iServicePiece;
import com.example.ProjetFilRougeGarage.service.iServiceTache;
import com.example.ProjetFilRougeGarage.service.iServiceUser;

@Controller
public class TacheController {
	@Autowired
	private iServiceTache servicetache;
	@Autowired
	private iServiceFiche servicefiche;
	@Autowired
	private IServicePriorite servicepriorite;
	@Autowired
	private iServicePiece servicepiece;

	@Autowired
	private iServiceUser serviceuser;

	private Tache convertForm(TacheForm tacheform) throws Exception {

		Tache tache = new Tache();
		tache.setId(tacheform.getId());
		tache.setCommentaire(tacheform.getCommentaire());
		tache.setEtattache(Boolean.valueOf(tacheform.getEtattache()));
		tache.setFiche(servicefiche.rechercherFicheId(Integer.parseInt(tacheform.getFiche())));
		tache.setPriorite(servicepriorite.rechercherPrioriteId(Integer.parseInt(tacheform.getPriorite())));
		tache.setPiece(servicepiece.recherchePieceId(Integer.parseInt(tacheform.getPiece())));
		tache.setDesactiver(false);// Boolean.valueOf(tacheform.getDesactiver()));
		tache.setUser(serviceuser.rechercherUserId(Integer.parseInt(tacheform.getUser())));
		tache.setQte(Integer.valueOf(tacheform.getQte()));
		return tache;
	}

	@GetMapping("/afficherCreerTache")
	public String getAffiche(Model pmodel) {
		List<Fiche> lfiches = servicefiche.rechercherFicheActive();
		List<Tache> ltaches = servicetache.rechercheTacheActive();
		List<User> luser = serviceuser.rechercherUser();
		List<Piece> lpiece = servicepiece.recherchePiece();
		List<Priorite> lpriorite = servicepriorite.rechercherPriorite();

		pmodel.addAttribute("listefiches", lfiches);
		pmodel.addAttribute("listepriorite", lpriorite);
		pmodel.addAttribute("listetache", ltaches);
		pmodel.addAttribute("listeuser", luser);
		pmodel.addAttribute("listepiece", lpiece);
		pmodel.addAttribute("action", "CreerTache");

		TacheForm tacheform = new TacheForm();
		tacheform.setId(0);
		pmodel.addAttribute("tacheform", tacheform);

		return "taches";
	}

	@GetMapping("/afficherModifierTache/{id}")
	public String getAfficheMod(@PathVariable final Integer id, Model pmodel) {
		Tache tache = servicetache.rechercherTacheId(id);
		List<Fiche> lfiches = servicefiche.rechercherFicheActive();
		List<User> luser = serviceuser.rechercherUser();
		List<Piece> lpiece = servicepiece.recherchePiece();
		List<Priorite> lpriorite = servicepriorite.rechercherPriorite();
		pmodel.addAttribute("listetache", null);
		pmodel.addAttribute("listefiches", lfiches);
		pmodel.addAttribute("listepriorite", lpriorite);
		pmodel.addAttribute("listeuser", luser);
		pmodel.addAttribute("listepiece", lpiece);
		pmodel.addAttribute("action", "ModifierTache");
		if (pmodel.containsAttribute("tacheform") == false) {
			TacheForm tacheform = new TacheForm();
			tacheform.setId(tache.getId());

			tacheform.setCommentaire(tache.getCommentaire());
			tacheform.setEtattache(String.valueOf(tache.getEtattache()));
			tacheform.setFiche(tache.getFiche().toString());
			tacheform.setPiece(tache.getPiece().toString());
			tacheform.setPriorite(tache.getPriorite().toString());
			tacheform.setUser(tache.getUser().toString());
			tacheform.setDesactiver(String.valueOf(tache.getDesactiver()));
			tacheform.setQte(String.valueOf(tache.getQte()));
			pmodel.addAttribute("tacheform", tacheform);
		}
		return "taches";
	}

	@GetMapping("/DesactiverTache/{id}")
	public String getDesactiver(@PathVariable final Integer id, Model pmodel) {
		Tache ptache = servicetache.rechercherTacheId(id);
		ptache.setDesactiver(true);
		servicetache.desactiverTache(ptache);

		return this.getAffiche(pmodel);
	}

	@PostMapping("/CreerTache")
	public String ajoutTache(@Valid @ModelAttribute(name = "tacheform") TacheForm tacheform, BindingResult presult,
			Model pmodel) {
		if (!presult.hasErrors()) {
			try {
				Tache tache = convertForm(tacheform);
				servicetache.creerTache(tache);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}

	@PostMapping("/ModifierTache")
	public String modifieTache(@Valid @ModelAttribute(name = "tacheform") TacheForm tacheform, BindingResult presult,
			Model pmodel) {
		if (!presult.hasErrors()) {
			try {
				Tache tache = convertForm(tacheform);
				servicetache.creerTache(tache);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}

}
