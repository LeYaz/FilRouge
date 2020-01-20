package com.example.ProjetFilRougeGarage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetFilRougeGarage.beans.CommandePiece;
import com.example.ProjetFilRougeGarage.dao.DaoCommandePiece;

@Service
public class ServiceCommandePiece implements IServiceCommandePiece {
	
	@Autowired
	DaoCommandePiece dao;
	
	@Transactional
	@Override
	public List<CommandePiece> rechercherCommandePiece() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	@Transactional
	@Override
	public CommandePiece rechercherCommandePieceId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}
	
	@Transactional
	@Override
	public void creerCommandePiece(CommandePiece pcommandepiece) {
		// TODO Auto-generated method stub
		dao.save(pcommandepiece);
	}

	@Transactional
	@Override
	public void modifierCommandePiece(CommandePiece pcommandepiece) {
		// TODO Auto-generated method stub
		dao.save(pcommandepiece);
	}

	@Transactional
	@Override
	public void desactiverCommandePiece(CommandePiece pcommandepiece) {
		// TODO Auto-generated method stub
		pcommandepiece.setDesactiver(true);
		dao.save(pcommandepiece);
	}

	@Override
	public List<CommandePiece> rechercherCommandePieceActive() {
		// TODO Auto-generated method stub
		return dao.listActive();
	}

}
