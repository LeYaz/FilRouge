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

import com.example.ProjetFilRougeGarage.beans.CommandePiece;
import com.example.ProjetFilRougeGarage.beans.Piece;
import com.example.ProjetFilRougeGarage.beans.User;
import com.example.ProjetFilRougeGarage.controller.form.CommandePieceForm;
import com.example.ProjetFilRougeGarage.service.IServiceCommandePiece;
import com.example.ProjetFilRougeGarage.service.iServicePiece;
import com.example.ProjetFilRougeGarage.service.iServiceUser;

@Controller
public class CommandePieceController {

	@Autowired
	private IServiceCommandePiece servicecommandepiece;
	
	@Autowired
	private iServiceUser serviceuser;
	
	@Autowired
	private iServicePiece servicepiece;
	
	private CommandePiece convertForm(CommandePieceForm commandepieceform) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date datecreation = sdf.parse(commandepieceform.getDate_creation());
		Date datecloture = null;
		if(commandepieceform.getDate_cloture().length()>1) {
			datecloture= sdf.parse(commandepieceform.getDate_cloture());
		}
		 
		CommandePiece comp = new CommandePiece();
		
		comp.setId(commandepieceform.getId());
		comp.setDate_cloture(datecloture);
		comp.setDate_creation(datecreation);
		comp.setDesactiver(false);
		comp.setPiece(servicepiece.recherchePieceId(Integer.valueOf(commandepieceform.getPiece())));
		comp.setQuantite(Integer.valueOf(commandepieceform.getQuantite()));
		comp.setUser(serviceuser.rechercherUserId(Integer.valueOf(commandepieceform.getUser())));
		
		
		return comp;
		
	}
	
	@GetMapping("/afficherCreerCommandePiece")
	public String getAffiche(Model pmodel) {
		List<CommandePiece> lcommandepiece = servicecommandepiece.rechercherCommandePieceActive();
		List<User> luser = serviceuser.rechercherUser();
		List<Piece> lpiece = servicepiece.recherchePiece();
		
		pmodel.addAttribute("listecommandepiece", lcommandepiece);
		pmodel.addAttribute("listeuser", luser);
		pmodel.addAttribute("listepiece", lpiece);
		pmodel.addAttribute("action", "CreerCommandePiece");
		
		if (pmodel.containsAttribute("commandepieceform") == false) {
			CommandePiece commandepieceform = new CommandePiece();
			commandepieceform.setId(0);
			pmodel.addAttribute("commandepieceform", commandepieceform);
		}
		
		return "commandepieces";
	}
	
	@GetMapping("/afficherModifierCommandePiece/{id}")
	public String getAfficheMod(@PathVariable final Integer id, Model pmodel) {
		CommandePiece pcommande = servicecommandepiece.rechercherCommandePieceId(id);
		List<User> luser = serviceuser.rechercherUser();
		List<Piece> lpiece = servicepiece.recherchePiece();
		
		pmodel.addAttribute("listecommandepiece", null);
		pmodel.addAttribute("listeuser", luser);
		pmodel.addAttribute("listepiece", lpiece);
		pmodel.addAttribute("action", "ModifierCommandePiece");
		if (pmodel.containsAttribute("commandepieceform") == false) {
			CommandePieceForm commandepieceform = new CommandePieceForm();
			commandepieceform.setId(pcommande.getId());
			
			if(commandepieceform.getDate_cloture()!=null) {
				commandepieceform.setDate_cloture(pcommande.getDate_cloture().toString());
			}
			
			commandepieceform.setDate_creation(pcommande.getDate_creation().toString());
			commandepieceform.setDesactiver(pcommande.getDesactiver().toString());
			commandepieceform.setPiece(pcommande.getPiece().getId().toString());
			commandepieceform.setQuantite(pcommande.getQuantite().toString());
			commandepieceform.setUser(pcommande.getUser().getId().toString());

			pmodel.addAttribute("commandepieceform", commandepieceform);
		}
		return "commandepieces";
	}
	
	@GetMapping("/DesactiverCommandePiece/{id}")
	public String getDesactiver(@PathVariable final Integer id, Model pmodel) {
		CommandePiece pcommande = servicecommandepiece.rechercherCommandePieceId(id);
		if (pcommande != null) {
			servicecommandepiece.desactiverCommandePiece(pcommande);
		}
		return this.getAffiche(pmodel);
	}
	
	@PostMapping("/CreerCommandePiece")
	public String ajoutUser(@Valid @ModelAttribute(name = "commandepieceform") CommandePieceForm commandepieceform, BindingResult presult,
			Model pmodel) {
		System.err.println(presult);
		if (!presult.hasErrors()) {
			try {
				CommandePiece commande = convertForm(commandepieceform);
				
				servicecommandepiece.creerCommandePiece(commande);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}

	@PostMapping("/ModifierCommandePiece")
	public String modifieUser(@Valid @ModelAttribute CommandePieceForm commandepieceform, BindingResult presult, Model pmodel) {
		if (!presult.hasErrors()) {
			try {
				CommandePiece commande = convertForm(commandepieceform);
				servicecommandepiece.modifierCommandePiece(commande);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	
}
