package com.example.ProjetFilRougeGarage.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjetFilRougeGarage.beans.CommandeVehicule;
import com.example.ProjetFilRougeGarage.beans.Devis;
import com.example.ProjetFilRougeGarage.beans.FactureDevis;
import com.example.ProjetFilRougeGarage.dao.DaoCommandeVehicule;
import com.example.ProjetFilRougeGarage.dao.DaoDevis;
import com.example.ProjetFilRougeGarage.dao.DaoFactureDevis;

@Service

public class ServiceDevis implements IServiceDevis {
	@Autowired
	private DaoDevis daoDevis;
	
	@Autowired
	private DaoCommandeVehicule daocommande;

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

			
			CommandeVehicule cmd = new CommandeVehicule();
			cmd.setDatecreation(new Date());
			cmd.setDesactiver(false);
			cmd.setDevis(this.rechercheDevisId(ld.get(index - 1).getId()));
			cmd.setEtat(false);
			
			daocommande.save(cmd);
		}

	}

	@Transactional
	@Override
	public void modifierDevis(Devis pdevis) {

		List<CommandeVehicule> lfd = daocommande.findAll();
		Boolean existe = true;
		for (CommandeVehicule fd : lfd) {

			if (pdevis.getId().equals(fd.getDevis().getId())) {
				existe = false;
			}

		}

		if (existe) {
			if (pdevis.getEtatdevis()) {
				CommandeVehicule cmd = new CommandeVehicule();
				cmd.setDatecreation(new Date());
				cmd.setDesactiver(false);
				cmd.setDevis(pdevis);
				cmd.setEtat(false);
				
				daocommande.save(cmd);
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
