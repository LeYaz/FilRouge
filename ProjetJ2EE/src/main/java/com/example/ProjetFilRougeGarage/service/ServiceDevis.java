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
	private DaoDevis daoDevis;
	
	@Autowired
	private DaoCommandeVehicule daocommande;

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

			
			CommandeVehicule cmd = new CommandeVehicule();
			cmd.setDatecreation(new Date());
			cmd.setDesactiver(false);
			cmd.setDevis(this.rechercheDevisId(ld.get(index - 1).getId()));
			cmd.setEtat(false);
			
			daocommande.save(cmd);
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
