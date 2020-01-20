package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import com.example.ProjetFilRougeGarage.beans.Priorite;

public interface IServicePriorite {

	public List<Priorite> rechercherPriorite();
	public Priorite rechercherPrioriteId(final int id);
	public void creerPriorite(final Priorite ppriorite);
	public void modifierPriorite(final Priorite ppriorite);
	public void desactiverPriorite(final Priorite ppriorite);
	public Priorite rechercherParNom(final String pname);
}
