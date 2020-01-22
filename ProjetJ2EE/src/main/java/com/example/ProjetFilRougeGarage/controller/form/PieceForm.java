package com.example.ProjetFilRougeGarage.controller.form;


import javax.validation.constraints.NotEmpty;

public class PieceForm {

	
	
	private Integer id;
	@NotEmpty
	private String libelle;
	@NotEmpty
	private String quantite;
	@NotEmpty
	private String date_saisie;
	
	private String desactiver;
	
	public String getDesactiver() {
		return desactiver;
	}
	public void setDesactiver(String desactiver) {
		this.desactiver = desactiver;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getQuantite() {
		return quantite;
	}
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
	public String getDate_saisie() {
		return date_saisie;
	}
	public void setDate_saisie(String date_saisie) {
		this.date_saisie = date_saisie;
	}
	
	
}
