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
@Table(name = "tache")
public class Tache {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String commentaire;
	@ManyToOne
	@JoinColumn(name="id_user", nullable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="id_fiche", nullable=false)
	private Fiche fiche;
	
	@ManyToOne
	@JoinColumn(name="id_priorite", nullable=false)
	private Priorite priorite;
	
	@ManyToOne
	@JoinColumn(name="id_piece", nullable=false)
	private Piece piece;
	
	private Integer qte;
	
	@Column(name="etattache", nullable=true)
	private Boolean etattache;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Fiche getFiche() {
		return fiche;
	}

	public void setFiche(Fiche fiche) {
		this.fiche = fiche;
	}

	public Priorite getPriorite() {
		return priorite;
	}

	public void setPriorite(Priorite priorite) {
		this.priorite = priorite;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public Boolean getEtattache() {
		return etattache;
	}

	public void setEtattache(Boolean etattache) {
		this.etattache = etattache;
	}

	@Override
	public String toString() {
		return "Tache [id=" + id + ", commentaire=" + commentaire + ", user=" + user + ", fiche=" + fiche
				+ ", priorite=" + priorite + ", qte=" + qte + ", etattache=" + etattache + "]";
	}


}
