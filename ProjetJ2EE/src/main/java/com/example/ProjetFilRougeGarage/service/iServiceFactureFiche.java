package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import com.example.ProjetFilRougeGarage.beans.FactureFiche;

public interface iServiceFactureFiche {

	public List<FactureFiche> rechercheFactureFiche();
	public FactureFiche rechercheFactureFicheId(final int id);
	public void creerFactureFiche(final FactureFiche facturefiche);
	public void modifierFactureFiche(final FactureFiche facturefiche);
	public void desactiverFactureFiche(final FactureFiche facturefiche);
	public List<FactureFiche> rechercheFactureFicheActive();
}
