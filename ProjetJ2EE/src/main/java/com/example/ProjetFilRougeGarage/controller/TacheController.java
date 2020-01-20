package com.example.ProjetFilRougeGarage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.ProjetFilRougeGarage.beans.Piece;
import com.example.ProjetFilRougeGarage.beans.Tache;
import com.example.ProjetFilRougeGarage.controller.form.PieceForm;
import com.example.ProjetFilRougeGarage.controller.form.TacheForm;
import com.example.ProjetFilRougeGarage.service.iServiceTache;

@Controller
public class TacheController {
@Autowired
private iServiceTache servicetache;
@Autowired
private iServiceFiche servicefiche;


private Tache convertForm(TacheForm tacheform) throws Exception {
	
	Tache tache = new Tache();
	tache.setId(tacheform.getId());
	tache.setCommentaire(tacheform.getCommentaire());
	tache.setEtattache(Boolean.valueOf(tacheform.getEtattache()));
	tache.setFiche(tacheform.getFiche().toString());
	ppiece.setQuantite(Integer.parseInt(pieceform.getQuantite()));
	ppiece.setDesactiver(Boolean.valueOf(pieceform.getDesactiver()));
	
	return ppiece;
}



}
