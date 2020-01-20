package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjetFilRougeGarage.beans.Devis;
import com.example.ProjetFilRougeGarage.dao.DaoDevis;
@Service

public class ServiceDevis implements IServiceDevis {
	@Autowired
	DaoDevis daoDevis;
	@Transactional
	@Override
	public List<Devis> rechercheDevis() {
		// TODO Auto-generated method stub
		return daoDevis.findAll();
	}
	@Transactional

	@Override
	public Devis rechercheDevisId(int id) {
		// TODO Auto-generated method stub
		return daoDevis.findById(id).get();
	}
	@Transactional

	@Override
	public void creerDevis(Devis pdevis) {
		// TODO Auto-generated method stub
		daoDevis.save(pdevis);

	}
	@Transactional
	@Override
	public void modifierDevis(Devis pdevis) {
		daoDevis.save(pdevis);
		
	}
	@Transactional
	@Override
	public void desactiverDevis(Devis pdevis) {
		daoDevis.save(pdevis);
		
	}



}
