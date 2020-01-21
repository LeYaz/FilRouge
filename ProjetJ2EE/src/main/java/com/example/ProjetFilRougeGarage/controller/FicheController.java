package com.example.ProjetFilRougeGarage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.ProjetFilRougeGarage.beans.Fiche;
import com.example.ProjetFilRougeGarage.beans.Priorite;
import com.example.ProjetFilRougeGarage.controller.form.FicheForm;
import com.example.ProjetFilRougeGarage.service.IServicePriorite;
import com.example.ProjetFilRougeGarage.service.iServiceFiche;

@Controller
public class FicheController {
//
//	@Autowired
//	private iServiceFiche servicefiche;
//	
//	@Autowired
//	private IServicePriorite servicepriorite;
//	
//	private Fiche convertForm(FicheForm ficheform) throws Exception {
//		Fiche pfiche = new Fiche();
//		List<Priorite> pList = new ArrayList<Priorite>();
//
//		for (String ppriorite : ficheform.get()) {
//			System.err.println(pprofil);
//			pList.add(servicefiche.rechercherFicheId(Integer.valueOf(pprofil)));
//			
//			
//		}
//
//		puser.setProfils(pList);
////		List<Profil> pListbis = serviceprofil.rechercherProfil();
//
//		puser.setProfils(pList);
//		puser.setId(userform.getId());
//		puser.setLogin(userform.getLogin());
//		puser.setNom(userform.getNom());
//		puser.setPrenom(userform.getPrenom());
//		puser.setPwd(userform.getPwd());
//
//		return puser;
//	}
}
