package com.example.ProjetFilRougeGarage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ProjetFilRougeGarage.beans.Profil;
import com.example.ProjetFilRougeGarage.beans.User;
import com.example.ProjetFilRougeGarage.service.iServiceProfil;
import com.example.ProjetFilRougeGarage.service.iServiceUser;

@SpringBootTest
class TestServiceUser {
	@Autowired
	private iServiceUser serviceuser;
	
	@Autowired 
	private iServiceProfil serviceprofil;
	
	private static Integer pId = 4;
	private static String pNom = "Test Nom";
	private static String pPrenom = "Test Prenom";
	private static String pLogin = "Login";
	private static String pPwd = "Pwd";
	private static List<Profil> pLprofils;
	
	
	private static String mNom = "Test Nom modif";
	private static String mPrenom = "Test Prenom modif";
	private static String mLogin = "Login modifier";
	private static String mPwd = "Pwd mod";
	private static List<Profil> mLprofils;
	

	@BeforeEach
	void setUpBeforeClass() throws Exception {
		pLprofils  = serviceprofil.rechercherProfil();
		mLprofils = new ArrayList<Profil>();
		Profil mprofil = serviceprofil.rechercherProfilId(1);
		mLprofils.add(mprofil);
		mprofil = serviceprofil.rechercherProfilId(3);
		mLprofils.add(mprofil);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRechercherUser() {
		List<User> luser = serviceuser.rechercherUser();
		
		assertNotNull(luser);
	}
	
	@Test
	void testRechercherUserId() {
		this.testCreerUser();
		
		User buser = serviceuser.rechercherUserId(pId);
		
		assertEquals(pLogin, buser.getLogin());
		assertEquals(pNom, buser.getNom());
		assertEquals(pPrenom, buser.getPrenom());
		assertEquals(pLprofils.toString(), buser.getProfils().toString());
		assertEquals(pPwd, buser.getPwd());
	}
	
	@Test
	void testmodifierUser() {
		User user = new User();
		
		user.setId(pId);
		user.setLogin(mLogin);
		user.setNom(mNom);
		user.setPrenom(mPrenom);
		user.setPwd(mPwd);
		user.setProfils(mLprofils);
		
		serviceuser.modifierUser(user);
		
		User muser = serviceuser.rechercherUserId(pId);
		
		assertEquals(mLogin,muser.getLogin());
		assertEquals(mNom, muser.getNom());
		assertEquals(mPrenom, muser.getPrenom());
		assertEquals(mPwd, muser.getPwd());
		assertEquals(mLprofils.toString(), muser.getProfils().toString());
	}
	
	@Test
	void testCreerUser() {
		User puser = new User();
		
		
		
		puser.setId(pId);
		puser.setLogin(pLogin);
		puser.setNom(pNom);
		puser.setPrenom(pPrenom);
		puser.setProfils(pLprofils);
		puser.setPwd(pPwd);
		
		serviceuser.creerUser(puser);
		
		
	}
	
	@Test
	void testDesactiverUser() {
		fail("Not yet implemented");
	}




}
