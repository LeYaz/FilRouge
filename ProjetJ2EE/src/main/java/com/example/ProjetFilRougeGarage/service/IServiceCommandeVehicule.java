package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import com.example.ProjetFilRougeGarage.beans.CommandePiece;
import com.example.ProjetFilRougeGarage.beans.CommandeVehicule;

public interface IServiceCommandeVehicule {
	public List<CommandeVehicule> rechercherCommandeVehicule();
	public CommandeVehicule rechercherCommandeVehiculeId(final int id);
	public void creerCommandeVehicule(final CommandeVehicule pcommandevehicule);
	public void modifierCommandeVehicule(final CommandeVehicule pcommandevehicule);
	public void desactiverCommandeVehicule(final CommandeVehicule pcommandevehicule);
	public List<CommandeVehicule> rechercherCommandeVehiculeActive();
}
