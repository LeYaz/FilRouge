package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetFilRougeGarage.beans.Priorite;
import com.example.ProjetFilRougeGarage.dao.DaoPriorite;

@Service
public class ServicePriorite implements IServicePriorite {

	@Autowired
	DaoPriorite dao;
	
	@Transactional
	@Override
	public List<Priorite> rechercherPriorite() {
		return dao.findAll();
	}

	@Transactional
	@Override
	public Priorite rechercherPrioriteId(int id) {
		return dao.findById(id).get();
	}

	@Transactional
	@Override
	public void creerPriorite(Priorite ppriorite) {
		dao.save(ppriorite);
	}

	@Transactional
	@Override
	public void modifierPriorite(Priorite ppriorite) {
		dao.save(ppriorite);
	}

	@Transactional
	@Override
	public void desactiverPriorite(Priorite ppriorite) {
		dao.save(ppriorite);
	}

	@Transactional
	@Override
	public Priorite rechercherParNom(String pname) {
		return (Priorite) dao.findByName(pname);
	}

}
