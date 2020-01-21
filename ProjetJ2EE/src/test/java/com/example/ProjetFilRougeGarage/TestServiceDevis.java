package com.example.ProjetFilRougeGarage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ProjetFilRougeGarage.beans.Devis;
import com.example.ProjetFilRougeGarage.beans.User;
import com.example.ProjetFilRougeGarage.beans.Vehicule;
import com.example.ProjetFilRougeGarage.service.IServiceClient;
import com.example.ProjetFilRougeGarage.service.IServiceDevis;
import com.example.ProjetFilRougeGarage.service.IServiceVehicule;
import com.example.ProjetFilRougeGarage.service.iServiceProfil;
import com.example.ProjetFilRougeGarage.service.iServiceUser;
@SpringBootTest
class TestServiceDevis {

	@Autowired 
	private IServiceDevis serviceDevis;
	
	@Autowired 
	private IServiceClient serviceClient;

	@Autowired 
	private iServiceUser serviceUser;

	@Autowired 
	private IServiceVehicule serviceVehicule;

	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("----------------");
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRechercheDevis() {
		serviceDevis.rechercheDevis();
		assertNotNull(serviceDevis.rechercheDevis());
	
	}

	@Test
	void testRechercheDevisId() {
		assertNotNull(serviceDevis.rechercheDevisId(2));
	}
	@Test
	void testCreerDevis() {
		Devis devis = new Devis();
		devis.setId(1);
		devis.setClient(serviceClient.rechercheClientId(1));
		devis.setUser(serviceUser.rechercherUserId(1));
		devis.setVehicule(serviceVehicule.rechercheVehiculeId(1));
		devis.setDatecreation(new Date());
		devis.setEtatdevis(false);
		devis.setDesactiver(false);
	}

	@Test
	void testModifierDevis() {
		Devis devis = serviceDevis.rechercheDevisId(1);
		assertEquals("test", serviceClient.rechercheClientId(1).getFirstname());
		devis.setClient(serviceClient.rechercheClientId(2));
		assertEquals("Abraham", devis.getClient().getFirstname());
		assertEquals("208",serviceVehicule.rechercheVehiculeId(4).getModele());
		//assertEquals(Integer.valueOf(50), serviceVehicule.rechercheVehiculeId(23).getQuantite());
		//assertEquals(new Date().getMonth(), serviceVehicule.rechercheVehiculeId(23).getDatecreation().getMonth());
		//assertEquals(Float.valueOf(150F), serviceVehicule.rechercheVehiculeId(23).getPrixht());
	}
	

	@Test
	void testDesactiverDevis() {
		Devis devis = serviceDevis.rechercheDevisId(1);
		devis.setDesactiver(true);
		serviceDevis.desactiverDevis(devis);
		assertTrue(serviceDevis.rechercheDevisId(1).getDesactiver());	}


}
