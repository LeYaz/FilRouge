package com.example.ProjetFilRougeGarage.service;

import java.util.ArrayList;
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
//		List<Piece> lpiece = daopiece.findAll();
//		
//		for(Piece p : lpiece) {
//			if(p.getDesactiver()){
//			lpiece.remove(p);
//			}
//		}
		return daopiece.listActive();
	}
	
	@Transactional
	@Override
	public List<Piece> recherchePiece() {
//		List<Piece> lpiece = daopiece.findAll();
//		
//		for(Piece p : lpiece) {
//			if(p.getDesactiver()){
//			lpiece.remove(p);
//			}
//		}
		return daopiece.findAll();
	}

	@Transactional
	@Override
	public Piece recherchePieceId(int id) {
		// TODO Auto-generated method stub
		return daopiece.findById(id).get();
	}

	@Transactional
	@Override
	public void creerPiece(Piece ppiece) {
		// TODO Auto-generated method stub
		daopiece.save(ppiece);
	}

	@Transactional
	@Override
	public void modifierPiece(Piece ppiece) {
		// TODO Auto-generated method stub
		daopiece.save(ppiece);
	}

	@Override
	public void desactiverPiece(Piece piece) {
	
		daopiece.save(piece);
	}


}