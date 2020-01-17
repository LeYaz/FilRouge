package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetFilRougeGarage.beans.Client;
import com.example.ProjetFilRougeGarage.dao.DaoClient;

@Service
public class ServiceClient implements IServiceClient {

	@Autowired
	DaoClient daoclient;
	
	@Transactional
	@Override
	public List<Client> rechercheClient() {
		return daoclient.findAll();
	}

	@Transactional
	@Override
	public Client rechercheClientId(int id) {
		return daoclient.findById(id).get();
	}

	@Transactional
	@Override
	public void creerClient(Client pclient) {
		daoclient.save(pclient);
	}

	@Transactional
	@Override
	public void modifierClient(Client pclient) {
		daoclient.save(pclient);
	}

	@Transactional
	@Override
	public void desactiverClient(Client pclient) {
		//daoclient.delete(pclient);
	}

}
