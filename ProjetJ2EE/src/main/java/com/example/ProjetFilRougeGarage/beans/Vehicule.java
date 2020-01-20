package com.example.ProjetFilRougeGarage.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "vehicule")
public class Vehicule {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="modele", length = 50, nullable = false)
	private String modele;
	
	@Column(name="marque", length = 50, nullable = false)
	private String marque;
	
	
	@Column(name="quantite", nullable = false)
	private Integer quantite;
	
	@Column(name="prixHT", columnDefinition = "float")
	private Float prixht;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_creation", nullable=false)
	private Date datecreation;
	
	@Column(name="desactiver" , columnDefinition ="bit(1)")
	private Boolean desactiver;


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

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Float getPrixht() {
		return prixht;
	}

	public void setPrixht(Float prixht) {
		this.prixht = prixht;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}



	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public Boolean getDesactiver() {
		return desactiver;
	}

	public void setDesactiver(Boolean desactiver) {
		this.desactiver = desactiver;
	}

	@Override
	public String toString() {
		return "Vehicule [id=" + id + ", modele=" + modele + ", marque=" + marque + ", quantite=" + quantite
				+ ", prixht=" + prixht + ", datecreation=" + datecreation + ", desactiver=" + desactiver + "]";
	}
	
}
