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
import com.example.ProjetFilRougeGarage.service.iServicePiece;

@SpringBootTest
class TestServicePiece {

	@Autowired
	private iServicePiece pservice;

	private static String libelle = "Moteur";
	private static Integer quantite = 4;
	private static Date date_saisie = new Date();
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
	void testRecherchePieceActive() {
		List<Piece> lp = pservice.recherchePieceActive();
		assertNotNull(lp);

	}

	@Test
	void testRecherchePiece() {

	}

	@Test
	void testRecherchePieceId() {
		assertNotNull(pservice.recherchePieceId(5));
	}

	@Test
	void testCreerPiece() {
		Piece piece = new Piece();
		piece.setLibelle(libelle);
		piece.setQuantite(quantite);
		piece.setDate_saisie(date_saisie);
		piece.setDesactiver(desactiver);
		pservice.creerPiece(piece);
	}

	@Test
	void testModifierPiece() {
		Piece p = pservice.recherchePieceId(5);
		p.setLibelle("moteur de test");
		pservice.modifierPiece(p);
		assertEquals(p.getLibelle(), "moteur de test");
	}

	@Test
	void testDesactiverPiece() {

		Piece p = pservice.recherchePieceId(16);
		p.setDesactiver(true);
		pservice.desactiverPiece(p);
		Piece pa = pservice.recherchePieceId(16);
		assertTrue(pa.getDesactiver());
	}

}
