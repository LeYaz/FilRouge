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
@Table(name = "commande_vehicule")
public class CommandeVehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_devis", nullable=false)
	private Devis devis;
	
	@Column(name="etat", columnDefinition ="bit(1)")
	private Boolean etat;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_creation")
	private Date datecreation;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_cloture")
	private Date datecloture;
}
