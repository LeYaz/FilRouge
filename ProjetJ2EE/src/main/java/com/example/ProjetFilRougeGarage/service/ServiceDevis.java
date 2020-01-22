package com.example.ProjetFilRougeGarage.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjetFilRougeGarage.beans.Devis;
import com.example.ProjetFilRougeGarage.beans.FactureDevis;
import com.example.ProjetFilRougeGarage.dao.DaoDevis;
import com.example.ProjetFilRougeGarage.dao.DaoFactureDevis;

@Service

public class ServiceDevis implements IServiceDevis {
	@Autowired
	DaoDevis daoDevis;
	@Autowired
	DaoFactureDevis daoFacture;

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

		List<Devis> ld = this.rechercheDevis();
		int index = ld.size();

		if (pdevis.getEtatdevis()) {
			FactureDevis facture = new FactureDevis();
			facture.setDatecreation(new Date());
			facture.setDesactiver(false);
			facture.setDevis(this.rechercheDevisId(ld.get(index - 1).getId()));
			facture.setPrixht(pdevis.getVehicule().getPrixht());
			facture.setTauxtva(0.2f);

			daoFacture.save(facture);

		}

	}

	@Transactional
	@Override
	public void modifierDevis(Devis pdevis) {

		List<FactureDevis> lfd = daoFacture.findAll();
		Boolean existe = true;
		for (FactureDevis fd : lfd) {

			if (pdevis.getId().equals(fd.getDevis().getId())) {
				existe = false;
			}

		}

		if (existe) {
			if (pdevis.getEtatdevis()) {
				FactureDevis facture = new FactureDevis();
				facture.setDatecreation(new Date());
				facture.setDesactiver(false);
				facture.setDevis(pdevis);
				facture.setPrixht(pdevis.getVehicule().getPrixht());
				facture.setTauxtva(0.2f);

				daoFacture.save(facture);
			}
		}

		daoDevis.save(pdevis);

	}

	@Transactional
	@Override
	public void desactiverDevis(Devis pdevis) {
		daoDevis.save(pdevis);

	}

	@Override
	public List<Devis> rechercherDevisActive() {
		// TODO Auto-generated method stub
		return daoDevis.listActive();
	}

}
