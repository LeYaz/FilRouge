package com.example.ProjetFilRougeGarage.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetFilRougeGarage.beans.CommandeVehicule;
import com.example.ProjetFilRougeGarage.beans.FactureDevis;
import com.example.ProjetFilRougeGarage.dao.DaoCommandeVehicule;
import com.example.ProjetFilRougeGarage.dao.DaoFactureDevis;

@Service
public class ServiceCommandeVehicule implements IServiceCommandeVehicule {
	@Autowired
	private DaoCommandeVehicule dao;
	@Autowired
	private DaoFactureDevis daoFacture;
	
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
		List<FactureDevis> ldevis = daoFacture.findAll();
		Boolean existe=true;
		for(FactureDevis devis : ldevis) {
			if(pcommandevehicule.getDevis().getId().equals(devis.getDevis().getId())) {
				existe=false;
			}
		}
		
		if (existe) {
			if (pcommandevehicule.getEtat()) {
				FactureDevis facture = new FactureDevis();
				facture.setDatecreation(new Date());
				facture.setDesactiver(false);
				facture.setDevis(pcommandevehicule.getDevis());
				facture.setPrixht(pcommandevehicule.getDevis().getVehicule().getPrixht());
				facture.setTauxtva(0.2f);
	
				daoFacture.save(facture);
			}
		}
		pcommandevehicule.setDatecloture(new Date());
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
