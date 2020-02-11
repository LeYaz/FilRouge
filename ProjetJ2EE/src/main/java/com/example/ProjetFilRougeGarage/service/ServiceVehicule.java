package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetFilRougeGarage.beans.Vehicule;
import com.example.ProjetFilRougeGarage.dao.DaoVehicule;

/**
 * 
 * @author Xavier
 *
 */
@Service
public class ServiceVehicule implements IServiceVehicule {

	/**
	 * Déclaration du dao
	 */
	@Autowired
	DaoVehicule daoVehicule;
	
	/**
	 * Permet d'accèder à tous les vehicules
	 * @return : la liste de tous les vehicules dans la base de données
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Vehicule> rechercheVehicule() {
		// TODO Auto-generated method stub
		return daoVehicule.findAll();
	}
	
	/**
	 * Permet d'accèder à un vehicule précis
	 * @param : id indique l'identifiant du vehicule à retourner
	 * @return : le vehicule ayant l'id passé en paramètre, si il existe
	 */
	@Transactional(readOnly = true)
	@Override
	public Vehicule rechercheVehiculeId(int id) {
		// TODO Auto-generated method stub
		return daoVehicule.findById(id).get();
	}
	
	/**
	 * Permet de créer un vehicule et de l'ajouter dans la base de données
	 * @param : le vehicule à créer 
	 */
	@Transactional
	@Override
	public void creerVehicule(Vehicule vehicule) {
		// TODO Auto-generated method stub
		daoVehicule.save(vehicule);
		
	}
	/**
	 * Permet de créer un vehicule et de l'ajouter dans la base de données
	 * @param : le vehicule à créer 
	 */
	@Transactional
	@Override
	public void modifierVehicule(Vehicule vehicule) {
		// TODO Auto-generated method stub
		daoVehicule.save(vehicule);

	}
	/**
	 * Permet de désactiver un vehicule, ce qui l'enleve de l'affichage sans le
	 * supprimer de la base de données
	 * @param : le vehicule à désactiver 
	 */
	@Transactional
	@Override
	public void desactiverVehicule(Vehicule vehicule) {
		vehicule.setDesactiver(true);
		daoVehicule.save(vehicule);
		
	}
	/**
	 * Permet de rechercher les véhicules actifs, et n'affiche pas les vehicules
	 * désactivés
	 * @return : la liste des véhicules dont l'attribut desactiver est à false
	 */
	@Transactional
	@Override
	public List<Vehicule> rechercherVehiculeActive() {
		// TODO Auto-generated method stub
		return daoVehicule.listActive();
	}

	
	
}
