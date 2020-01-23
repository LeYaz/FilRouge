package com.example.ProjetFilRougeGarage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ProjetFilRougeGarage.beans.Piece;
import com.example.ProjetFilRougeGarage.beans.Tache;
import com.example.ProjetFilRougeGarage.service.IServicePriorite;
import com.example.ProjetFilRougeGarage.service.iServiceFiche;
import com.example.ProjetFilRougeGarage.service.iServicePiece;
import com.example.ProjetFilRougeGarage.service.iServiceTache;
import com.example.ProjetFilRougeGarage.service.iServiceUser;
@SpringBootTest
class TestServiceTache {

	
	@Autowired
	private iServiceTache servicetache;
	@Autowired
	private iServiceFiche servicefiche;
	@Autowired
	private IServicePriorite servicepriorite;
	@Autowired
	private iServicePiece servicepiece;
	@Autowired
	private iServiceUser serviceuser;
	
	private static String commentaire = "Moteur de la gole 6 à changer";
	private static Integer qte = 1;
	private static Boolean etattache= true;
	private static Boolean desactiver = true;
	
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
	void testRechercheTacheActive() {
		List<Tache> lt = servicetache.rechercheTacheActive();
		assertNotNull(lt);
	}

	@Test
	void testRechercherTache() {
		
	}

	@Test
	void testRechercherTacheId() {
		assertNotNull(servicetache.rechercherTacheId(1));
	}

	@Test
	void testCreerTache() {
		Tache tache = new Tache();
		tache.setCommentaire(commentaire);
		tache.setFiche(servicefiche.rechercherFicheId(2));
		tache.setEtattache(etattache);
		tache.setPiece(servicepiece.recherchePieceId(3));
		tache.setDesactiver(desactiver);
		tache.setQte(qte);
		tache.setUser(serviceuser.rechercherUserId(2));
		tache.setPriorite(servicepriorite.rechercherPrioriteId(2));
		servicetache.creerTache(tache);
	}

	@Test
	void testModifierTache() {
		Tache t = servicetache.rechercherTacheId(1);
		t.setCommentaire("test changement commentaire");;
		servicetache.modifierTache(t);
		assertEquals(t.getCommentaire(), "test changement commentaire");
	}

	@Test
	void testDesactiverTache() {
		Tache tache = servicetache.rechercherTacheId(2);
		tache.setDesactiver(true);
		servicetache.desactiverTache(tache);
		Tache t = servicetache.rechercherTacheId(4);
		assertTrue(t.getDesactiver());
	}

}
