package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetFilRougeGarage.beans.Vehicule;
import com.example.ProjetFilRougeGarage.dao.DaoVehicule;

@Service
public class ServiceVehicule implements IServiceVehicule {

	@Autowired
	DaoVehicule daoVehicule;
	@Transactional(readOnly = true)
	@Override
	public List<Vehicule> rechercheVehicule() {
		// TODO Auto-generated method stub
		return daoVehicule.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Vehicule rechercheVehiculeId(int id) {
		// TODO Auto-generated method stub
		return daoVehicule.findById(id).get();
	}
	@Transactional
	@Override
	public void creerVehicule(Vehicule vehicule) {
		// TODO Auto-generated method stub
		daoVehicule.save(vehicule);
		
	}
	@Transactional
	@Override
	public void modifierVehicule(Vehicule vehicule) {
		// TODO Auto-generated method stub
		daoVehicule.save(vehicule);

	}
	@Transactional
	@Override
	public void desactiverVehicule(Vehicule vehicule) {
		// TODO Auto-generated method stub
		
	}

	
	
}
