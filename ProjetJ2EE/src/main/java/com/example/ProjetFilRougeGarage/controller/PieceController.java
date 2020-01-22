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
import com.example.ProjetFilRougeGarage.controller.form.PieceForm;
import com.example.ProjetFilRougeGarage.service.iServicePiece;

@Controller
public class PieceController {
@Autowired
private iServicePiece servicepiece;
	
	private Piece convertForm(PieceForm pieceform) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Piece ppiece = new Piece();
		Date date = sdf.parse(pieceform.getDate_saisie()); 
		ppiece.setId(pieceform.getId());
		ppiece.setLibelle(pieceform.getLibelle());
		ppiece.setDate_saisie(date);
		ppiece.setQuantite(Integer.parseInt(pieceform.getQuantite()));
		ppiece.setDesactiver(Boolean.valueOf(pieceform.getDesactiver()));
		
		return ppiece;
	}
	
	@GetMapping("/afficherCreerPiece")
	public String getAffiche(Model pmodel) {
		List<Piece> lpiece = servicepiece.recherchePieceActive();
		
		pmodel.addAttribute("listepiece", lpiece);
		
		pmodel.addAttribute("action", "CreerPiece");
		if(!pmodel.containsAttribute("pieceform"))
		{
			PieceForm pieceform = new PieceForm();
			pieceform.setId(0);
			pmodel.addAttribute("pieceform",pieceform);
		}
		return "pieces";
	}
	
	@GetMapping("/afficherModifierPiece/{id}")
	public String getAfficheMod(@PathVariable final Integer id,Model pmodel) {
		Piece ppiece = servicepiece.recherchePieceId(id);
		
		pmodel.addAttribute("listepiece", null);

		pmodel.addAttribute("action", "ModifierPiece");
		if(pmodel.containsAttribute("pieceform") == false) {
			PieceForm pieceform = new PieceForm();
		pieceform.setId(ppiece.getId());
			
			pieceform.setLibelle(ppiece.getLibelle());
			pieceform.setDate_saisie(ppiece.getDate_saisie().toString());
			pieceform.setQuantite(String.valueOf(ppiece.getQuantite()));
			pmodel.addAttribute("pieceform", pieceform);
		}
		return "pieces";
	}
	
	@GetMapping("/DesactiverPiece/{id}")
	public String getDesactiver(@PathVariable final Integer id,Model pmodel) {
		Piece ppiece = servicepiece.recherchePieceId(id);
		ppiece.setDesactiver(true);
		servicepiece.desactiverPiece(ppiece);
		//pmodel.addAttribute("action", "ModifierPiece");
		
		return this.getAffiche(pmodel);
	}
	
	@PostMapping("/CreerPiece")
	public String ajoutPiece( 
			@Valid @ModelAttribute(name = "pieceform") PieceForm pieceform,
			BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Piece ppiece = convertForm(pieceform);
				servicepiece.creerPiece(ppiece);
				pieceform = new PieceForm();
				pieceform.setId(0);
				pmodel.addAttribute("pieceform",pieceform);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}

		}
		
		return this.getAffiche(pmodel);
	}

	@PostMapping("/ModifierPiece")
	public String modifiePiece( 
			@Valid @ModelAttribute(name = "pieceform") PieceForm pieceform,
			 BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Piece ppiece = convertForm(pieceform);
				servicepiece.creerPiece(ppiece);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	
}
