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
@Table(name = "fiche")
public class Fiche {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_client", nullable=false)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="id_user", nullable=false)
	private User user;
	
	@Column(name="etatfiche", nullable=true)
	private Boolean etatfiche;
	
	@ManyToOne
	@JoinColumn(name="id_priorite", nullable=false)
	private Priorite priorite;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date_creation", nullable=false)
	private Date datecreation;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date_cloture", nullable=false)
	private Date datecloture;
	
	@Column(name="description", nullable=true)
	private String description;
	
	@Column(name="desactiver" , columnDefinition ="bit(1)")
	private Boolean desactiver;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getEtatfiche() {
		return etatfiche;
	}

	public void setEtatfiche(Boolean etatfiche) {
		this.etatfiche = etatfiche;
	}

	public Priorite getPriorite() {
		return priorite;
	}

	public void setPriorite(Priorite priorite) {
		this.priorite = priorite;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public Date getDatecloture() {
		return datecloture;
	}

	public void setDatecloture(Date datecloture) {
		this.datecloture = datecloture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getDesactiver() {
		return desactiver;
	}

	public void setDesactiver(Boolean desactiver) {
		this.desactiver = desactiver;
	}

	
}
