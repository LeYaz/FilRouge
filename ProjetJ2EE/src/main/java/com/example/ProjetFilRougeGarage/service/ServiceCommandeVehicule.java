package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetFilRougeGarage.beans.CommandeVehicule;
import com.example.ProjetFilRougeGarage.dao.DaoCommandeVehicule;

@Service
public class ServiceCommandeVehicule implements IServiceCommandeVehicule {
	@Autowired
	private DaoCommandeVehicule dao;
	
	@Transactional
	@Override
	public List<CommandeVehicule> rechercherCommandeVehicule() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	@Transactional
	@Override
	public CommandeVehicule rechercherCommandeVehiculeId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Transactional
	@Override
	public void creerCommandeVehicule(CommandeVehicule pcommandevehicule) {
		// TODO Auto-generated method stub
		dao.save(pcommandevehicule);
	}

	@Transactional
	@Override
	public void modifierCommandeVehicule(CommandeVehicule pcommandevehicule) {
		// TODO Auto-generated method stub
		dao.save(pcommandevehicule);
	}

	@Transactional
	@Override
	public void desactiverCommandeVehicule(CommandeVehicule pcommandevehicule) {
		// TODO Auto-generated method stub
		pcommandevehicule.setDesactiver(true);
		
		dao.save(pcommandevehicule);
	}

	@Transactional
	@Override
	public List<CommandeVehicule> rechercherCommandeVehiculeActive() {
		// TODO Auto-generated method stub
		return dao.listActive();
	}

}
