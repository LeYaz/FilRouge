package com.example.ProjetFilRougeGarage.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "facture_fiche")
public class FactureFiche {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_fiche", nullable=false)
	private Fiche fiche;
	
	@Column(name="prixHT", columnDefinition = "float")
	private Float prixht;
	
	@Column(name="tauxTVA", columnDefinition = "float")
	private Float tauxTVA;

	private Boolean desactiver;
	
	public Boolean getDesactiver() {
		return desactiver;
	}

	public void setDesactiver(Boolean desactiver) {
		this.desactiver = desactiver;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Fiche getFiche() {
		return fiche;
	}

	public void setFiche(Fiche fiche) {
		this.fiche = fiche;
	}

	public Float getPrixht() {
		return prixht;
	}

	public void setPrixht(Float prixht) {
		this.prixht = prixht;
	}

	public Float getTauxTVA() {
		return tauxTVA;
	}

	public void setTauxTVA(Float tauxTVA) {
		this.tauxTVA = tauxTVA;
	}

	@Override
	public String toString() {
		return "FactureFiche [id=" + id + ", fiche=" + fiche + ", prixht=" + prixht + ", tauxTVA=" + tauxTVA + "]";
	}
	
}
