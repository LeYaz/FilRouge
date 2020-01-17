package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetFilRougeGarage.beans.Profil;
import com.example.ProjetFilRougeGarage.dao.DaoProfil;

@Service
public class ServiceProfil implements iServiceProfil {
	@Autowired
	DaoProfil dao;
	
	@Transactional
	@Override
	public List<Profil> rechercherProfil() {
		// TODO Auto-generated method stub
//		List<Profil> lprofil =dao.findAll();
//		for(Profil p : lprofil) {
//			//test desactiver
//			
//			lprofil.remove(p);
//		}
		return dao.findAll();
	}

	@Transactional
	@Override
	public Profil rechercherProfilId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Transactional
	@Override
	public void creerProfil(Profil pprofil) {
		// TODO Auto-generated method stub
		dao.save(pprofil);
	}

	@Transactional
	@Override
	public void modifierProfil(Profil pprofil) {
		// TODO Auto-generated method stub
		dao.save(pprofil);
	}

	@Transactional
	@Override
	public void desactiverProfil(Profil pprofil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Profil rechercherParNom(String pname) {
		// TODO Auto-generated method stub
		return (Profil)dao.findByName(pname);
	}

}
