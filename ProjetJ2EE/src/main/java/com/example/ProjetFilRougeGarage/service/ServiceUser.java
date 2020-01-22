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
	
	/**
	 * @return La liste entiere des User
	 */
	@Transactional
	@Override
	public List<User> rechercherUser() {
		return dao.findAll();
	}
	
	/**
	 * @param id correspond à l'id du user chercher en bdd
	 * @return L'entité User correpondant à l'id
	 */
	@Transactional
	@Override
	public User rechercherUserId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}


	/**
	 * @param puser correspond à l'entité User à ajouter en bdd
	 */
	@Transactional
	@Override
	public void creerUser(User puser) {
		// TODO Auto-generated method stub
		dao.save(puser);
	}

	/**
	 * @param puser correspond à l'entité User a mettre à jour en bdd
	 */
	@Transactional
	@Override
	public void modifierUser(User puser) {
		// TODO Auto-generated method stub
		dao.save(puser);
	}
	
	/**
	 * @param puser correspond à l'entité User a désactiver en bdd
	 */
	@Transactional
	@Override
	public void desactiverUser(User puser) {
		// TODO Auto-generated method stub
		puser.setDesactiver(true);
		dao.save(puser);

	}
	
	/**
	 * @return retourne la liste des user en bdd pour lesquels desactiver est faux
	 */
	@Override
	public List<User> rechercherUserActive() {
		// TODO Auto-generated method stub
		return dao.listActive();
	}

	
}
