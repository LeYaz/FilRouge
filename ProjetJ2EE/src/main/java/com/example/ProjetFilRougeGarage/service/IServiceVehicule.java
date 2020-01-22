package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import com.example.ProjetFilRougeGarage.beans.Vehicule;


public interface IServiceVehicule {
	
	public List<Vehicule> rechercheVehicule();
	public Vehicule rechercheVehiculeId(final int id);
	public void creerVehicule(final Vehicule vehicule);
	public void modifierVehicule(final Vehicule vehicule);
	public void desactiverVehicule(final Vehicule vehicule);
	public List<Vehicule> rechercherVehiculeActive();

}
