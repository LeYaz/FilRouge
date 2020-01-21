package com.example.ProjetFilRougeGarage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ProjetFilRougeGarage.beans.CommandePiece;
import com.example.ProjetFilRougeGarage.beans.Piece;
import com.example.ProjetFilRougeGarage.beans.User;
import com.example.ProjetFilRougeGarage.service.IServiceCommandePiece;
import com.example.ProjetFilRougeGarage.service.iServicePiece;
import com.example.ProjetFilRougeGarage.service.iServiceUser;

@SpringBootTest
class TestServiceCommandePiece {
	@Autowired
	private IServiceCommandePiece servicecmd;
	
	@Autowired
	private iServicePiece servicepiece;
	
	@Autowired
	private iServiceUser serviceuser;
	
	private static Integer cId = 1;
	private static Integer cQuantite =10;
	private static Date cdate_creation = new Date();
	private static Date cdate_cloture = new Date();
	private static User cuser;
	private static Piece cpiece;
	private Boolean cdesactiver = false;
	
	
	private static Integer mQuantite =15;
	private static Date mdate_creation;
	private static Date mdate_cloture;
	private static User muser;
	private static Piece mpiece;
	private Boolean mdesactiver = true;
	
	@BeforeEach
	void setUp() throws Exception {
		cuser = serviceuser.rechercherUserId(cId);
		cpiece = servicepiece.recherchePieceId(cId);
		
		muser = serviceuser.rechercherUserId(2);
		mpiece = servicepiece.recherchePieceId(2);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRechercherCommandePiece() {
		List<CommandePiece> lcp = servicecmd.rechercherCommandePiece();
		
		assertNotNull(lcp);
	}
	
	@Test
	void testRechercherCommandePieceId() {
		this.testCreerCommandePiece();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		CommandePiece cp = servicecmd.rechercherCommandePieceId(cId);
		
		assertEquals(sdf.format(cdate_cloture),sdf.format(cp.getDate_cloture()));
		assertEquals(sdf.format(cdate_creation), sdf.format(cp.getDate_creation()));
		assertEquals(cdesactiver, cp.getDesactiver());
		assertEquals(cpiece.getId(), cp.getPiece().getId());
		assertEquals(cQuantite, cp.getQuantite());
		assertEquals(cuser.getId(), cp.getUser().getId());
	}
	
	@Test
	void testCreerCommandePiece() {
		CommandePiece cmdp = new CommandePiece();
		
		cmdp.setId(cId);
		cmdp.setDate_cloture(cdate_cloture);
		cmdp.setDate_creation(cdate_creation);
		cmdp.setDesactiver(cdesactiver);
		cmdp.setPiece(cpiece);
		cmdp.setQuantite(cQuantite);
		cmdp.setUser(cuser);
		
		servicecmd.creerCommandePiece(cmdp);
	}
	
	@Test
	void testModifierCommandePiece() {
		CommandePiece mcmdp = new CommandePiece();
		mdate_cloture = new Date();
		mdate_creation = new Date();
		mcmdp.setId(cId);
		mcmdp.setDate_cloture(mdate_cloture);
		mcmdp.setDate_creation(mdate_creation);
		mcmdp.setDesactiver(mdesactiver);
		mcmdp.setPiece(mpiece);
		mcmdp.setQuantite(mQuantite);
		mcmdp.setUser(muser);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		servicecmd.modifierCommandePiece(mcmdp);
		
		 mcmdp = servicecmd.rechercherCommandePieceId(cId);
		
		assertEquals(sdf.format(mdate_cloture),sdf.format(mcmdp.getDate_cloture()));
		assertEquals(sdf.format(mdate_creation), sdf.format(mcmdp.getDate_creation()));
		assertEquals(mdesactiver, mcmdp.getDesactiver());
		assertEquals(mpiece.getId(), mcmdp.getPiece().getId());
		assertEquals(mQuantite, mcmdp.getQuantite());
		assertEquals(muser.getId(), mcmdp.getUser().getId());
		
	}
	
	@Test
	void testDesactiverCommandePiece() {
		CommandePiece cp = servicecmd.rechercherCommandePieceId(cId);
		cp.setDesactiver(false);
		servicecmd.desactiverCommandePiece(cp);
		assertTrue(servicecmd.rechercherCommandePieceId(cId).getDesactiver());
	}
	
	
}
