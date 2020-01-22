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
		return dao.findAll();
	}

	@Transactional
	@Override
	public Profil rechercherProfilId(int id) {
		return dao.findById(id).get();
	}

	@Transactional
	@Override
	public void creerProfil(Profil pprofil) {
		dao.save(pprofil);
	}

	@Transactional
	@Override
	public void modifierProfil(Profil pprofil) {
		dao.save(pprofil);
	}

	@Transactional
	@Override
	public void desactiverProfil(Profil pprofil) {
		// TODO Auto-generated method stub
		
	}

	@Transactional 
	@Override
	public Profil rechercherParNom(String pname) {
		return (Profil)dao.findByName(pname);
	}

}
