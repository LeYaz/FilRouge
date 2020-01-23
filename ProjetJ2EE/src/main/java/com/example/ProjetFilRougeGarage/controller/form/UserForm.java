package com.example.ProjetFilRougeGarage.controller.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserForm {
	
	private Integer id;

	@NotEmpty
	private String nom;

	@NotEmpty
	private String prenom;

	@NotEmpty
	private String login;

	@NotEmpty
	@Size(min=2, message="Le mot de passe doit comporter au minimum 2 caractère")
	private String pwd;
	
	@NotEmpty
	private List<String> profils = new ArrayList<String>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<String> getProfils() {
		return profils;
	}

	public void setProfils(List<String> profils) {
		this.profils = profils;
	}
	
	
}
