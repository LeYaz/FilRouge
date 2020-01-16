package com.example.ProjetFilRougeGarage.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="lastname", length=50, nullable=false)
	private String nom;
	
	@Column(name="firstname", length=50, nullable=false)
	private String prenom;
	
	@Column(name="login", length=15, nullable=false)
	private String login;
	
	@Column(name="pwd", length=10, nullable=false)
	private String pwd;
	
	@ManyToMany 
	@JoinTable( name="PROFIL_USER",  
	joinColumns=@JoinColumn(name="ID_USER"), 
	inverseJoinColumns=@JoinColumn(name="ID_PROFIL")  ) 
	private List<Profil> profils;
	
	public List<Profil> getProfils() {
		return profils;
	}

	public void setProfils(List<Profil> profils) {
		this.profils = profils;
	}

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

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", pwd=" + pwd
				+ ", profils=" + profils + "]";
	}

	
	
	
}
