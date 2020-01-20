package com.example.ProjetFilRougeGarage;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ProjetFilRougeGarage.beans.Client;
import com.example.ProjetFilRougeGarage.service.IServiceClient;
import com.example.ProjetFilRougeGarage.service.ServiceClient;


@SpringBootTest
class TestClient {
	@Autowired
	private IServiceClient serviceclient;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("===========================");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRechercheClient() {
		IServiceClient service = new ServiceClient();
		System.out.println(service.rechercheClient());
		System.out.println(service.rechercheClient().size());
	}

	@Test
	void testRechercheClientId() {
		IServiceClient service = new ServiceClient();
		System.out.println(service.rechercheClientId(1));

}

	@Test
	void testCreerClient() {
		
		Client cl = new Client();
		
		cl.setId(1);
		cl.setName("test");
		cl.setFirstname("test");
		cl.setAdresse("testadresse");
		cl.setCodepostal("test000");
		cl.setVille("test");
		cl.setTel("000000000");
		cl.setPortable("00000000");		
		
		serviceclient.creerClient(cl);
	}

	@Test
	void testModifierClient() {
		Client client = serviceclient.rechercheClientId(1);
		client.setCodepostal("12000");
		serviceclient.modifierClient(client);
	}

	@Test
	void testDesactiverClient() {
		fail("Not yet implemented");
	}

}
