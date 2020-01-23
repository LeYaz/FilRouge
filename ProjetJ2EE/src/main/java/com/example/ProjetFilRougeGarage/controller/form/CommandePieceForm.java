package com.example.ProjetFilRougeGarage.controller.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CommandePieceForm {


	private Integer id;
	
	@NotEmpty
	@Pattern(regexp = "\\d*", message="nombre uniquement")
	@Min(value = 1)
	private String quantite;
	
	@NotEmpty
	@Size(max=10, message="Veuillez entrer une date valide!")
	private String date_creation;
	
	private String date_cloture;
	
	@NotEmpty
	private String user;
	
	@NotEmpty
	private String piece;
	
	
	private String desactiver;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPiece() {
		return piece;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}

	public String getDesactiver() {
		return desactiver;
	}

	public void setDesactiver(String desactiver) {
		this.desactiver = desactiver;
	}
	
	
}
