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

/**
 * 
 * @author Xavier
 *
 */

@Service
public class ServiceDevis implements IServiceDevis {
	/**
	 * Importation des ADO
	 */
	@Autowired
	DaoDevis daoDevis;
	@Autowired
	DaoFactureDevis daoFacture;

	/**
	 * Permet de rechercher la liste des devis
	 * @return : la liste des devis
	 */
	@Transactional	
	@Override
	public List<Devis> rechercheDevis() {
		// TODO Auto-generated method stub
		return daoDevis.findAll();
	}

	/**
	 * Permet de rechercher un Devis donné (qui peut être retrouvé grâce à son ID)
	 * @param : l'id du Devis a trouver
	 * @return : le devis désiré si il existe un devis avec l'id mis en paramètre
	 */
	@Transactional
	@Override
	public Devis rechercheDevisId(int id) {
		// TODO Auto-generated method stub
		return daoDevis.findById(id).get();
	}

	/**
	 * Permet de créer un devis dans la liste des devis.
	 * Crée également une facture de devis quand un devis est crée
	 * @param : le devis a creer
	 */
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
	/**
	 * Permet de créer un devis dans la liste des devis.
	 * Permet de créer une facture de devis si un devis existant non accepté est
	 * coché à accepté
	 * @param : le devis a creer
	 */
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
/**
 * Permet de desactiver un devis, le supprime de la liste d'affichage sans le 
 * supprimer de la base de données.
 * @param: le devis à désactiver
 */
	@Transactional
	@Override
	public void desactiverDevis(Devis pdevis) {
		daoDevis.save(pdevis);

	}
/*
 * la liste des devis toujours actifs, n'affichera pas les devis désactivés
	 * @return : la liste des devis dont l'attribut desactiver est à false
 */
	@Override
	public List<Devis> rechercherDevisActive() {
		// TODO Auto-generated method stub
		return daoDevis.listActive();
	}

}
