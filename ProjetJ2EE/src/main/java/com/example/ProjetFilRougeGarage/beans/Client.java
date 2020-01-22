package com.example.ProjetFilRougeGarage.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")

public class Client {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nom", length = 50, nullable = false)
	private String name;
	
	@Column(name="prenom" , length=50, nullable=false)
	private String firstname;
	
	@Column(name="adresse", length=50, nullable=false)
	private String adresse;
	
	@Column(name="code_postal", length=50, nullable=false)
	private String codepostal;
	
	@Column(name="ville", length=50, nullable=false)
	private String ville;
	
	@Column(name="telephone", length=50, nullable=false)
	private String tel;
	
	@Column(name="mobile", length=50, nullable=false)
	private String portable;
	
	@Column(name="desactiver" , columnDefinition ="bit(1)")
	private Boolean desactiver;

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

	public Boolean getDesactiver() {
		return desactiver;
	}

	public void setDesactiver(Boolean desactiver) {
		this.desactiver = desactiver;
	}


	
	
}
