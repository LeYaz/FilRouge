package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetFilRougeGarage.beans.User;
import com.example.ProjetFilRougeGarage.dao.DaoUser;

@Service
public class ServiceUser implements iServiceUser {
	
	@Autowired
	DaoUser dao;
	
	@Transactional
	@Override
	public List<User> rechercherUser() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Transactional
	@Override
	public User rechercherUserId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Transactional
	@Override
	public void creerUser(User puser) {
		// TODO Auto-generated method stub
		dao.save(puser);
	}

	@Transactional
	@Override
	public void modifierUser(User puser) {
		// TODO Auto-generated method stub
		dao.save(puser);
	}

	@Transactional
	@Override
	public void desactiverUser(User puser) {
		// TODO Auto-generated method stub

	}

	
}
