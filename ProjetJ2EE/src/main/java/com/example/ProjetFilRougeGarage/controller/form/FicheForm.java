package com.example.ProjetFilRougeGarage.controller.form;

import javax.validation.constraints.NotEmpty;

public class FicheForm {


		private Integer id;
		
		@NotEmpty
		private String client;
		
		@NotEmpty
		private String user;
		
		
		private String etatfiche;
		
		@NotEmpty
		private String priorite;

		@NotEmpty
		private String datecreation; 

		
		private String datecloture;
		
		private String description;
		
		
		private String desactiver;


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public String getClient() {
			return client;
		}


		public void setClient(String client) {
			this.client = client;
		}


		public String getUser() {
			return user;
		}


		public void setUser(String user) {
			this.user = user;
		}


		public String getEtatfiche() {
			return etatfiche;
		}


		public void setEtatfiche(String etatfiche) {
			this.etatfiche = etatfiche;
		}


		public String getPriorite() {
			return priorite;
		}


		public void setPriorite(String priorite) {
			this.priorite = priorite;
		}


		public String getDatecreation() {
			return datecreation;
		}


		public void setDatecreation(String datecreation) {
			this.datecreation = datecreation;
		}


		public String getDatecloture() {
			return datecloture;
		}


		public void setDatecloture(String datecloture) {
			this.datecloture = datecloture;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public String getDesactiver() {
			return desactiver;
		}


		public void setDesactiver(String desactiver) {
			this.desactiver = desactiver;
		}
		
		
		
}
