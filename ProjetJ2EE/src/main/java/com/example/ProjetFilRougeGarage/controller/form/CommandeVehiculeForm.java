package com.example.ProjetFilRougeGarage.controller.form;

import javax.validation.constraints.NotEmpty;

public class CommandeVehiculeForm {

	private Integer id;

	@NotEmpty
	private String date_creation;

	private String date_cloture;

	@NotEmpty
	private String devis;

	@NotEmpty
	private String etat;

	private String desactiver;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(String date_creation) {
		this.date_creation = date_creation;
	}

	public String getDate_cloture() {
		return date_cloture;
	}

	public void setDate_cloture(String date_cloture) {
		this.date_cloture = date_cloture;
	}

	public String getDevis() {
		return devis;
	}

	public void setDevis(String devis) {
		this.devis = devis;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getDesactiver() {
		return desactiver;
	}

	public void setDesactiver(String desactiver) {
		this.desactiver = desactiver;
	}
	
	
}
