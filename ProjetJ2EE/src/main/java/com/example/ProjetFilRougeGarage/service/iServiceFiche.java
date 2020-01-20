package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import com.example.ProjetFilRougeGarage.beans.Fiche;


public interface iServiceFiche {

	public List<Fiche> rechercherFiche();
	public Fiche rechercherFicheId(final int id);
	public void creerFiche(final Fiche pfiche);
	public void modifierFiche(final Fiche pfiche);
	public void desactiverFiche(final Fiche pfiche);
	
}
