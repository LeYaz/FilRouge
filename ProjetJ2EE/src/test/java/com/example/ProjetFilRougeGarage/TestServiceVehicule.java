package com.example.ProjetFilRougeGarage;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

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
		
	}

	@Test
	void testRechercheVehiculeId() {
		Integer id =2;
		serviceVehicule.rechercheVehiculeId(id);
	}

	@Test
	void testCreerVehicule() {
		Vehicule vehicule = new Vehicule();
		vehicule.setId(88);
		vehicule.setModele("Pougeot");
		vehicule.setQuantite(666);
		vehicule.setDatecreation(new Date());
		vehicule.setPrixht(150.00F);
		serviceVehicule.creerVehicule(vehicule);
			
	}

	@Test
	void testModifierVehicule() {
		Vehicule vehicule = serviceVehicule.rechercheVehiculeId(1);
		vehicule.setQuantite(50);;
		serviceVehicule.modifierVehicule(vehicule);
		
	}

	@Test
	void testDesactiverVehicule() {
		fail("Not yet implemented");
	}

}
