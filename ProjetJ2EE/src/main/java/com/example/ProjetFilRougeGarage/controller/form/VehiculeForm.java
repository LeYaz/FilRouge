package com.example.ProjetFilRougeGarage.controller.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;


public class VehiculeForm {


	
	private Integer id;
	@NotEmpty
	private String modele;
	@NotEmpty
	private String quantite;
	@NotEmpty
	private String prixht;
	@NotEmpty
	private String datecreation;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getQuantite() {
		return quantite;
	}
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
	public String getPrixht() {
		return prixht;
	}
	public void setPrixht(String prixht) {
		this.prixht = prixht;
	}
	public String getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(String datecreation) {
		this.datecreation = datecreation;
	}
	
}
