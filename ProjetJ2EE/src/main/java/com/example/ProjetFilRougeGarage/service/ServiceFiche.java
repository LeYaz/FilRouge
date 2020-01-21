package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetFilRougeGarage.beans.Fiche;
import com.example.ProjetFilRougeGarage.dao.DaoFiche;

@Service
public class ServiceFiche implements iServiceFiche {

	@Autowired
	DaoFiche dao;

	@Transactional
	@Override
	public List<Fiche> rechercherFicheActive() {
		return dao.listActive();
	}

	@Transactional
	@Override
	public Fiche rechercherFicheId(int id) {
		return dao.findById(id).get();
	}

	@Transactional
	@Override
	public void creerFiche(Fiche pfiche) {
		dao.save(pfiche);
	}

	@Transactional
	@Override
	public void modifierFiche(Fiche pfiche) {
		dao.save(pfiche);
	}

	@Transactional
	@Override
	public void desactiverFiche(Fiche pfiche) {
		dao.save(pfiche);
	}

	@Override
	public List<Fiche> rechercherFiche() {
		return dao.findAll();
	}

}
