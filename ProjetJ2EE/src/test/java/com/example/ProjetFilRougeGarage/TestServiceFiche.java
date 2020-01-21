package com.example.ProjetFilRougeGarage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ProjetFilRougeGarage.beans.Client;
import com.example.ProjetFilRougeGarage.beans.Fiche;
import com.example.ProjetFilRougeGarage.service.IServiceClient;
import com.example.ProjetFilRougeGarage.service.IServicePriorite;
import com.example.ProjetFilRougeGarage.service.iServiceFiche;
import com.example.ProjetFilRougeGarage.service.iServiceUser;

@SpringBootTest
class TestServiceFiche {
	
	@Autowired
	private iServiceFiche servicefiche;

	
	@Autowired
	private IServiceClient serviceclient;
	
	@Autowired
	private iServiceUser serviceuser;
	
	@Autowired
	private IServicePriorite serviceprio;
	
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("===========================");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	//@Test
	void testRechercherFicheActive() {
		fail("Not yet implemented");
	}

	@Test
	void testRechercheFicheId() {
		assertNotNull(servicefiche.rechercherFicheId(2));

	}

	@Test
	void testCreerFiche() {
		Fiche fiche = new Fiche();
		
		fiche.setId(1);
		fiche.setClient(serviceclient.rechercheClientId(1));
		fiche.setUser(serviceuser.rechercherUserId(1));
		fiche.setPriorite(serviceprio.rechercherPrioriteId(1));
		fiche.setDatecreation(new Date());
		fiche.setDatecloture(new Date());
		
		servicefiche.creerFiche(fiche);
		
		
	}

	@Test
	void testModifierFiche() {
		Fiche fiche = new Fiche();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		fiche.setId(1);
		fiche.setClient(serviceclient.rechercheClientId(1));
		fiche.setUser(serviceuser.rechercherUserId(1));
		fiche.setPriorite(serviceprio.rechercherPrioriteId(1));
		fiche.setDatecreation(new Date());
		fiche.setDatecloture(new Date());
		
		servicefiche.creerFiche(fiche);
		
		Fiche fiche2 = new Fiche();
		fiche2 = servicefiche.rechercherFicheId(1);
		
		assertEquals(fiche.getClient().getId(), fiche2.getClient().getId());
		assertEquals(fiche.getUser().getId(), fiche2.getUser().getId());
		assertEquals(fiche.getPriorite().getId(), fiche2.getPriorite().getId());
		assertEquals(fiche.getEtatfiche(), fiche2.getEtatfiche());
		assertEquals(sdf.format(fiche.getDatecreation()), sdf.format(fiche2.getDatecreation()));
		assertEquals(sdf.format(fiche.getDatecloture()), sdf.format(fiche2.getDatecloture()));
		
		
	}

	@Test
	void testDesactiverFiche() {
		List<Fiche> lfiche = servicefiche.rechercherFicheActive();
		for (Fiche fiche : lfiche) {
			assertFalse(fiche.getDesactiver());
		}
		}

	@Test
	void testRechercherFiche() {
		List<Fiche> lfiche = servicefiche.rechercherFiche();
		assertNotNull(lfiche);
	}

}
