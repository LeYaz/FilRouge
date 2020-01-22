package com.example.ProjetFilRougeGarage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ProjetFilRougeGarage.beans.Vehicule;
import com.example.ProjetFilRougeGarage.service.IServiceVehicule;

@SpringBootTest
class TestServiceVehicule {

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
	void testRechercheVehicule() {
		serviceVehicule.rechercheVehicule();
		assertNotNull(serviceVehicule.rechercheVehicule());
	
	}

	@Test
	void testRechercheVehiculeId() {
		assertNotNull(serviceVehicule.rechercheVehiculeId(2));
	}

	@Test
	void testCreerVehicule() {
		Vehicule vehicule = new Vehicule();
		vehicule.setId(8);
		vehicule.setModele("Pougeot");
		vehicule.setMarque("Truc");
		vehicule.setQuantite(666);
		vehicule.setDatecreation(new Date());
		vehicule.setPrixht(150F);
		serviceVehicule.creerVehicule(vehicule);
		assertNotNull(serviceVehicule.rechercheVehiculeId(8));
		}

	@Test
	void testModifierVehicule() {
		Vehicule vehicule = serviceVehicule.rechercheVehiculeId(7);
		vehicule.setQuantite(50);
		serviceVehicule.modifierVehicule(vehicule);
		//assertEquals("Pougeot", serviceVehicule.rechercheVehiculeId(23).getModele());
		//assertEquals(Integer.valueOf(50), serviceVehicule.rechercheVehiculeId(23).getQuantite());
		//assertEquals(new Date().getMonth(), serviceVehicule.rechercheVehiculeId(23).getDatecreation().getMonth());
		//assertEquals(Float.valueOf(150F), serviceVehicule.rechercheVehiculeId(23).getPrixht());
		assertEquals(Integer.valueOf(50), serviceVehicule.rechercheVehiculeId(7).getQuantite());
	}

	@Test
	void testDesactiverVehicule() {
		Vehicule vehicule = serviceVehicule.rechercheVehiculeId(7);
		vehicule.setDesactiver(true);
		assertEquals(true, vehicule.getDesactiver());
	}
	
	@Test
	void testRechercherVehiculeException() {
	try {
		serviceVehicule.rechercheVehiculeId(99999);
		fail( "Erreur" );
	} catch (Exception expectedException) {
		expectedException.getMessage();

	}
	}
	
	@Test
	void testCreerVehiculeExisteSansInfo() {
		Vehicule vehicule = new Vehicule();

	try {
		serviceVehicule.creerVehicule(vehicule);
	
		fail( "Erreur" );
	} catch (Exception expectedException) {
		expectedException.getMessage();

	}
	assertNull(vehicule.getId());
	}

	@Test
	void testCreerVehiculeModifierImpossible() {
		Vehicule vehicule = serviceVehicule.rechercheVehiculeId(7);

	try {
		vehicule.setQuantite(Integer.parseInt("fdsfds"));
		serviceVehicule.modifierVehicule(vehicule);
		fail( "Erreur" );
	} catch (Exception expectedException) {
		expectedException.getMessage();
	}	}
	
	

}
