package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import com.example.ProjetFilRougeGarage.beans.FactureDevis;


public interface IServiceFactureDevis {
	public List<FactureDevis> rechercheFactureDevis();
	public FactureDevis rechercheFactureDevisId(final int id);
	public void creerFactureDevis(final FactureDevis factureDevis);
	public void modifierFactureDevis(final FactureDevis factureDevis);
	public void desactiverFactureDevis(final FactureDevis factureDevis);
	List<FactureDevis> rechercherFactureDevisActive();
}
