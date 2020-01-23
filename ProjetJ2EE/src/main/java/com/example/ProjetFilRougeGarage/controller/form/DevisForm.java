package com.example.ProjetFilRougeGarage.controller.form;

import javax.validation.constraints.NotEmpty;

public class DevisForm {
	private Integer id;

	@NotEmpty
	private String client;

	@NotEmpty
	private String vehicule;

	@NotEmpty
	private String user;

	@NotEmpty
	private String datecreation;

	private String etatdevis;

	private String desactiver;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getVehicule() {
		return vehicule;
	}
	public void setVehicule(String vehicule) {
		this.vehicule = vehicule;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(String datecreation) {
		this.datecreation = datecreation;
	}
	public String getEtatdevis() {
		return etatdevis;
	}
	public void setEtatdevis(String etatdevis) {
		this.etatdevis = etatdevis;
	}
	public String getDesactiver() {
		return desactiver;
	}
	public void setDesactiver(String desactiver) {
		this.desactiver = desactiver;
	}
	
}
