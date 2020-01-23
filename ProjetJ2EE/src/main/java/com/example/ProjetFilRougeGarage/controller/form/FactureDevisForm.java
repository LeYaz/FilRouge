package com.example.ProjetFilRougeGarage.controller.form;

public class FactureDevisForm {
	private Integer id;
	
	private String devis;
	
	private String prixht;
	
	private String tauxtva;

	private String datecreation;
	
	private String desactiver;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDevis() {
		return devis;
	}

	public void setDevis(String devis) {
		this.devis = devis;
	}

	public String getPrixht() {
		return prixht;
	}

	public void setPrixht(String prixht) {
		this.prixht = prixht;
	}

	public String getTauxtva() {
		return tauxtva;
	}

	public void setTauxtva(String tauxtva) {
		this.tauxtva = tauxtva;
	}

	public String getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(String datecreation) {
		this.datecreation = datecreation;
	}

	public String getDesactiver() {
		return desactiver;
	}

	public void setDesactiver(String desactiver) {
		this.desactiver = desactiver;
	}
	
}
