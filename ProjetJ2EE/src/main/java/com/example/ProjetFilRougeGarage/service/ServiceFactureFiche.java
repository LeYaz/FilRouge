package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetFilRougeGarage.beans.FactureFiche;
import com.example.ProjetFilRougeGarage.dao.DaoFactureFiche;

@Service
public class ServiceFactureFiche implements iServiceFactureFiche {

	@Autowired
	DaoFactureFiche daofacturefiche;

	@Transactional
	@Override
	public List<FactureFiche> rechercheFactureFiche() {

		return daofacturefiche.findAll();
	}

	@Transactional
	@Override
	public FactureFiche rechercheFactureFicheId(int id) {
		return daofacturefiche.findById(id).get();
	}
	@Transactional
	@Override
	public void creerFactureFiche(FactureFiche facturefiche) {
		
		daofacturefiche.save(facturefiche);
	}
	@Transactional
	@Override
	public void modifierFactureFiche(FactureFiche facturefiche) {
		
		daofacturefiche.save(facturefiche);
	}
	@Transactional
	@Override
	public void desactiverFactureFiche(FactureFiche facturefiche) {
		daofacturefiche.save(facturefiche);

	}
	@Transactional
	@Override
	public List<FactureFiche> rechercheFactureFicheActive() {
		// TODO Auto-generated method stub
		return daofacturefiche.listActive();
	}

}
