package com.example.ProjetFilRougeGarage.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjetFilRougeGarage.beans.Piece;
import com.example.ProjetFilRougeGarage.dao.DaoPiece;



@Service
public class ServicePiece implements iServicePiece {
	@Autowired
	DaoPiece daopiece;
	
	@Transactional
	@Override
	public List<Piece> recherchePieceActive() {
		return daopiece.listActive();
	}
	
	@Transactional
	@Override
	public List<Piece> recherchePiece() {
		return daopiece.findAll();
	}

	@Transactional
	@Override
	public Piece recherchePieceId(int id) {
		return daopiece.findById(id).get();
	}

	@Transactional
	@Override
	public void creerPiece(Piece ppiece) {

		daopiece.save(ppiece);
	}

	@Transactional
	@Override
	public void modifierPiece(Piece ppiece) {
		daopiece.save(ppiece);
	}
	@Transactional
	@Override
	public void desactiverPiece(Piece piece) {
	
		daopiece.save(piece);
	}

}