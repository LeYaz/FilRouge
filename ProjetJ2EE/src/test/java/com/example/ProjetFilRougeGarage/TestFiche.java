package com.example.ProjetFilRougeGarage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.ProjetFilRougeGarage.beans.Client;
import com.example.ProjetFilRougeGarage.beans.Fiche;
import com.example.ProjetFilRougeGarage.beans.Priorite;
import com.example.ProjetFilRougeGarage.beans.User;
import com.example.ProjetFilRougeGarage.service.iServiceFiche;

class TestFiche {
	
	@Autowired
	private iServiceFiche servicefiche;
	
	private static Integer pId = 4;
	private static Client pLclients;
	private static User pLusers;
	private static Priorite pLpriorites;
	private static Boolean pEtatfiche = false;
	private static Date pDatecrea = new Date("2020-01-01");
	private static Date pDateclot = new Date("2020-01-02");
	
	
	
	private static Client mLclients;
	private static User mLusers;
	private static Priorite mLpriorites;
	private static Boolean mEtatfiche = true;
	private static Date mDatecrea = new Date("2020-01-03");
	private static Date mDateclot = new Date("2020-01-04");

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRechercherFicheActive() {
		fail("Not yet implemented");
	}

	@Test
	void testRechercherFicheId() {
		this.testCreerFiche();
		
		Fiche bfiche = servicefiche.rechercherFicheId(pId);
		
		
		assertEquals(pLclients.toString(), bfiche.getClient().toString());
		assertEquals(pLusers.toString(), bfiche.getClient().toString());
		assertEquals(pLpriorites.toString(), bfiche.getClient().toString());
		assertEquals(pEtatfiche, bfiche.getEtatfiche());
		assertEquals(pDatecrea, bfiche.getDatecreation());
		assertEquals(pDateclot, bfiche.getDatecloture());
		
	}

	@Test
	void testCreerFiche() {
		Fiche fiche = new Fiche();
		fiche.setId(1);
		fiche.setClient(pLclients);
		fiche.setUser(pLusers);
		fiche.setPriorite(pLpriorites);
		fiche.setDatecreation(pDatecrea);
		fiche.setDatecloture(pDateclot);
		
		servicefiche.creerFiche(fiche);
		
		
	}

	@Test
	void testModifierFiche() {
		Fiche fiche = new Fiche();
		fiche.setId(pId);
		fiche.setClient(mLclients);
		fiche.setUser(mLusers);
		fiche.setPriorite(mLpriorites);
		fiche.setDatecreation(mDatecrea);
		fiche.setDatecloture(mDateclot);
		
		servicefiche.creerFiche(fiche);
		
		Fiche fiche2 = new Fiche();
		
		assertEquals(mLclients.toString(), fiche2.getClient().toString());
		assertEquals(mLusers.toString(), fiche2.getClient().toString());
		assertEquals(mLpriorites.toString(), fiche2.getClient().toString());
		assertEquals(pEtatfiche, fiche2.getEtatfiche());
		assertEquals(mDatecrea, fiche2.getDatecreation());
		assertEquals(mDateclot, fiche2.getDatecloture());
		
		
	}

	@Test
	void testDesactiverFiche() {
		Fiche fiche = servicefiche.rechercherFicheId(pId);
		fiche.setDesactiver(false);
		servicefiche.desactiverFiche(fiche);
		assertTrue(servicefiche.rechercherFicheId(pId).getDesactiver());	}

	@Test
	void testRechercherFiche() {
		List<Fiche> lfiche = servicefiche.rechercherFiche();
		assertNotNull(lfiche);
	}

}
