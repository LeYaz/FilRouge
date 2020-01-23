package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetFilRougeGarage.beans.FactureFiche;
import com.example.ProjetFilRougeGarage.beans.Fiche;
import com.example.ProjetFilRougeGarage.dao.DaoFactureFiche;
import com.example.ProjetFilRougeGarage.dao.DaoFiche;

@Service
public class ServiceFiche implements iServiceFiche {

	@Autowired
	DaoFiche dao;
	@Autowired
	DaoFactureFiche daoFFiche;
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
//		if(pfiche.getEtatfiche()==true) {
//		FactureFiche facturefiche = new FactureFiche();
		
		
	//	}
		dao.save(pfiche);
		
		List<Fiche> lf = this.rechercherFiche();
		int index = lf.size();

		if (pfiche.getEtatfiche()) {
			FactureFiche facture = new FactureFiche();
			facture.setDesactiver(false);
			facture.setFiche(this.rechercherFicheId(lf.get(index - 1).getId()));
			facture.setPrixht(0f);
			facture.setTauxTVA(0.2f);

			daoFFiche.save(facture);

		}

	}
	

	@Transactional
	@Override
	public void modifierFiche(Fiche pfiche) {
		
		List<FactureFiche> lff = daoFFiche.findAll();
		Boolean existe = true;
		for (FactureFiche ff : lff) {

			if (pfiche.getId().equals(ff.getFiche().getId())) {
				existe = false;
			}

		}

		if (existe) {
			if (pfiche.getEtatfiche()) {
				FactureFiche fiche = new FactureFiche();
				fiche.setDesactiver(false);
				fiche.setFiche(pfiche);
				fiche.setPrixht(0f);
				fiche.setTauxTVA(0.2f);
			
				daoFFiche.save(fiche);
			}
		}
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
