package com.example.ProjetFilRougeGarage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ProjetFilRougeGarage.beans.FactureFiche;
import com.example.ProjetFilRougeGarage.service.iServiceFactureFiche;
@SpringBootTest
class TestServiceFactureFiche {
	@Autowired
	iServiceFactureFiche serviceff;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRechercheFactureFiche() {
		List<FactureFiche> lf = serviceff.rechercheFactureFiche();
		assertNotNull(lf);
	}

	@Test
	void testRechercheFactureFicheId() {
		assertNotNull(serviceff.rechercheFactureFicheId(1));
	}

	
	@Test
	void testDesactiverFactureFiche() {
		FactureFiche ff = serviceff.rechercheFactureFicheId(2);
		ff.setDesactiver(true);
		serviceff.desactiverFactureFiche(ff);
		FactureFiche f = serviceff.rechercheFactureFicheId(2);
		assertTrue(f.getDesactiver());
	}

	@Test
	void testRechercheFactureFicheActive() {
		List<FactureFiche> lff = serviceff.rechercheFactureFicheActive();
		assertNotNull(lff);
	}

}
