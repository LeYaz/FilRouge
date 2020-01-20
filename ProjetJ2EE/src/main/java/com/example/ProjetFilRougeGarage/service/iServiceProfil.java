package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import com.example.ProjetFilRougeGarage.beans.Profil;

public interface iServiceProfil {

	public List<Profil> rechercherProfil();
	public Profil rechercherProfilId(final int id);
	public void creerProfil(final Profil pprofil);
	public void modifierProfil(final Profil pprofil);
	public void desactiverProfil(final Profil pprofil);
	public Profil rechercherParNom(final String pname);
}
