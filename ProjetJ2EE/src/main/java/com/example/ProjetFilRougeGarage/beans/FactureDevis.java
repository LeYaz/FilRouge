package com.example.ProjetFilRougeGarage.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="facture_devis")
public class FactureDevis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_devis", nullable=false)
	private Devis devis;
	
	@Column(name="prixHT", columnDefinition = "float")
	private Float prixht;
	
	@Column(name="tauxTVA", columnDefinition = "float")
	private Float tauxtva;
	
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

	public Devis getDevis() {
		return devis;
	}

	public void setDevis(Devis devis) {
		this.devis = devis;
	}

	public Float getPrixht() {
		return prixht;
	}

	public void setPrixht(Float prixht) {
		this.prixht = prixht;
	}

	public Float getTauxtva() {
		return tauxtva;
	}

	public void setTauxtva(Float tauxtva) {
		this.tauxtva = tauxtva;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public Boolean getDesactiver() {
		return desactiver;
	}

	public void setDesactiver(Boolean desactiver) {
		this.desactiver = desactiver;
	}
	
	
}
