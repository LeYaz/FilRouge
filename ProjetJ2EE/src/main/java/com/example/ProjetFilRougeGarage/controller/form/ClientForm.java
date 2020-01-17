package com.example.ProjetFilRougeGarage.controller.form;

import javax.validation.constraints.NotEmpty;

public class ClientForm {

	private Integer id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String firstname;
	
	@NotEmpty
	private String adresse;
	
	@NotEmpty
	private String codepostal;
	
	@NotEmpty
	private String ville;
	
	@NotEmpty
	private String tel;
	
	@NotEmpty
	private String portable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPortable() {
		return portable;
	}

	public void setPortable(String portable) {
		this.portable = portable;
	}
	
	
	
}
