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

import com.example.ProjetFilRougeGarage.beans.CommandeVehicule;
import com.example.ProjetFilRougeGarage.beans.Devis;
import com.example.ProjetFilRougeGarage.service.IServiceCommandeVehicule;
import com.example.ProjetFilRougeGarage.service.IServiceDevis;

@SpringBootTest
class TestServiceCommandeVehicule {
	@Autowired 
	private IServiceCommandeVehicule servicecmd;
	
	@Autowired 
	private IServiceDevis servicedevis;
	
	private static Integer cId = 1;
	private static Date cdate_creation = new Date();
	private static Date cdate_cloture = new Date();
	private Boolean cdesactiver = false;
	private Boolean cetat = false;
	private Devis cdevis;
	
	private static Date mdate_creation;
	private static Date mdate_cloture;
	private Boolean mdesactiver = true;
	private Boolean metat = true;
	private Devis mdevis;
	

	@BeforeEach
	void setUp() throws Exception {
		cdevis = servicedevis.rechercheDevisId(cId);
		
		mdevis = servicedevis.rechercheDevisId(2);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRechercherCommandePiece() {
		List<CommandeVehicule> lcv = servicecmd.rechercherCommandeVehicule();
		
		assertNotNull(lcv);
	}
	
	@Test
	void testRechercherCommandePieceId() {
		this.testCreerCommandePiece();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		CommandeVehicule cp = servicecmd.rechercherCommandeVehiculeId(cId);
		
		assertEquals(sdf.format(cdate_cloture),sdf.format(cp.getDatecloture()));
		assertEquals(sdf.format(cdate_creation), sdf.format(cp.getDatecreation()));
		assertEquals(cdesactiver, cp.getDesactiver());
		assertEquals(cetat, cp.getEtat());
		assertEquals(cdevis.getId(), cp.getDevis().getId());
	}
	
	@Test
	void testCreerCommandePiece() {
		CommandeVehicule cmdp = new CommandeVehicule();
		
		cmdp.setId(cId);
		cmdp.setDatecloture(cdate_cloture);
		cmdp.setDatecreation(cdate_creation);
		cmdp.setDesactiver(cdesactiver);
		cmdp.setDevis(cdevis);
		cmdp.setEtat(cetat);
		
		servicecmd.creerCommandeVehicule(cmdp);
	}
	
	@Test
	void testModifierCommandePiece() {
		CommandeVehicule mcmdp = new CommandeVehicule();
		mdate_cloture = new Date();
		mdate_creation = new Date();
		mcmdp.setId(cId);
		mcmdp.setDatecloture(mdate_cloture);
		mcmdp.setDatecreation(mdate_creation);
		mcmdp.setDesactiver(mdesactiver);
		mcmdp.setDevis(mdevis);
		mcmdp.setEtat(metat);
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		servicecmd.modifierCommandeVehicule(mcmdp);
		
		 mcmdp = servicecmd.rechercherCommandeVehiculeId(cId);
		
		assertEquals(sdf.format(mdate_cloture),sdf.format(mcmdp.getDatecloture()));
		assertEquals(sdf.format(mdate_creation), sdf.format(mcmdp.getDatecreation()));
		assertEquals(mdesactiver, mcmdp.getDesactiver());
		assertEquals(mdevis.getId(), mcmdp.getDevis().getId());
		assertEquals(metat, mcmdp.getEtat());
		
		
	}
	
	@Test
	void testDesactiverCommandePiece() {
		CommandeVehicule cp = servicecmd.rechercherCommandeVehiculeId(cId);
		cp.setDesactiver(false);
		servicecmd.desactiverCommandeVehicule(cp);
		assertTrue(servicecmd.rechercherCommandeVehiculeId(cId).getDesactiver());
	}

}
