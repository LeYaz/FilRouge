package com.example.ProjetFilRougeGarage.controller.form;

import javax.validation.constraints.NotEmpty;

public class FactureFicheForm {


	private Integer id;
	
	
	private String fiche;
	
	@NotEmpty
	private String prixht;
	@NotEmpty
	private String tauxTVA;
	@NotEmpty
	private String desactiver;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFiche() {
		return fiche;
	}
	public void setFiche(String fiche) {
		this.fiche = fiche;
	}
	public String getPrixht() {
		return prixht;
	}
	public void setPrixht(String prixht) {
		this.prixht = prixht;
	}
	public String getTauxTVA() {
		return tauxTVA;
	}
	public void setTauxTVA(String tauxTVA) {
		this.tauxTVA = tauxTVA;
	}
	public String getDesactiver() {
		return desactiver;
	}
	public void setDesactiver(String desactiver) {
		this.desactiver = desactiver;
	}
	
	

}
