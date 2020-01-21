package com.example.ProjetFilRougeGarage.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="devis")
@NamedQueries({
	@NamedQuery( name = "Devis.findAll", query = "SELECT d FROM Devis AS d" ),
	@NamedQuery(name="Devis.findByClient", query="SELECT d FROM Devis AS d WHERE d.client.id = ?1")
})
public class Devis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * On decrrit une jointure entre la colonnes id_client et le beans client
	 * avec sa cle kp @ID
	 */
	@ManyToOne
	@JoinColumn(name="id_client", nullable=false)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="id_vehicule", nullable=false)
	private Vehicule vehicule;
	
	@ManyToOne
	@JoinColumn(name="id_user", nullable=false)
	private User user;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_creation", nullable=false)
	private Date datecreation;
	
	@Column(name="etatdevis", nullable=true)
	private Boolean etatdevis;

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

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public Boolean getEtatdevis() {
		return etatdevis;
	}

	public void setEtatdevis(Boolean etatdevis) {
		this.etatdevis = etatdevis;
	}

	@Override
	public String toString() {
		return "Devis [id=" + id + ", client=" + client + ", vehicule=" + vehicule + ", user=" + user
				+ ", datecreation=" + datecreation + ", etatdevis=" + etatdevis + "]";
	}

	public Boolean getDesactiver() {
		return desactiver;
	}

	public void setDesactiver(Boolean desactiver) {
		this.desactiver = desactiver;
	}

	public String devisEtat()
	{
		String resultat="";
		if (etatdevis==true)
		{
			resultat="Regle";
		}
		return resultat;
	}
	
	
}
