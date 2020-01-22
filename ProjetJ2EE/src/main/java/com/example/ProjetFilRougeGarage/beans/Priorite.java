package com.example.ProjetFilRougeGarage.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "priorite")

public class Priorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String libelle;
	
	@Column(name="desactiver" , columnDefinition ="bit(1)")
	private Boolean desactiver;

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

	public Boolean getDesactiver() {
		return desactiver;
	}

	public void setDesactiver(Boolean desactiver) {
		this.desactiver = desactiver;
	}

	
}
