package com.example.ProjetFilRougeGarage.controller.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class VehiculeForm {


	
	private Integer id;
	@NotEmpty
	private String modele;
	@NotEmpty
	@Pattern(regexp = "\\d*", message="nombre uniquement")
	@Min(value = 1)
	private String quantite;
	@NotEmpty
	@Pattern(regexp = "\\d*", message="nombre uniquement")
	@Min(value = 1)
	private String prixht;
	@NotEmpty
	@Size(max=10, message="Veuillez entrer une date valide!")
	private String datecreation;
	@NotEmpty
	private String marque;
	
	private String desactiver;

	
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
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getDesactiver() {
		return desactiver;
	}
	public void setDesactiver(String desactiver) {
		this.desactiver = desactiver;
	}
	
}
