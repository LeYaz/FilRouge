package com.example.ProjetFilRougeGarage.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetFilRougeGarage.beans.Piece;
import com.example.ProjetFilRougeGarage.service.iServicePiece;

/**
 * RestController mapper sur /RestPiece/
 * Permettant d'effectuer un CRUD sur la table piece
 * 
 * @author Yazid
 * 
 *
 */
@RestController
@RequestMapping("/RestPiece/")
public class PieceControllerRest {
	@Autowired 
	private iServicePiece servicepiece;
	
	/**
	 *   Methode mapper sur /RestPiece/Pieces 
	 *   
	 * @return la liste des Pieces au format JSON
	 * 
	 */
	@GetMapping("/Pieces")
	public List<Piece> getPieces(){
		return servicepiece.recherchePieceActive();
	}
	
	/**
	 * Methode mapper sur /RestPiece/Pieces/{id}
	 * Permettant de recuperer les données d'une pieces
	 * @param id correspond a l'id de la piece a retourner		
	 * @return Les données d'une Piece au format JSON
	 */
	@GetMapping("/Pieces/{id}")
	public Piece getPiece(@PathVariable("id") int id){
		return servicepiece.recherchePieceId(id);
	}
	
	/**
	 * Methode mapper sur /RestPiece/Pieces/{id}
	 * Permettant de desactiver une pieces
	 * @param id correspond a l'id de la piece a desactiver
	 * @return Les données de la pieces desactiver au format JSON
	 */
	@DeleteMapping("/Pieces/{id}")
	public Piece deletePiece(@PathVariable("id") int id){
		Piece p = servicepiece.recherchePieceId(id);
		servicepiece.desactiverPiece(p);
		return p;
	}
	
	/**
	 * Methode mapper sur /RestPiece/Pieces/{id}
	 * Permettant de mettre à jour une piece
	 * @param id correspond a l'id de la piece a mettre à jour
	 * @param ppiece au données de la piece a mettre à jour
	 * @return la Piece avec ses données mise à jour 
	 */
	@PutMapping("/Pieces/{id}")
	public Piece updatePiece(@PathVariable("id") int id, @RequestBody Piece ppiece){
		Piece p = servicepiece.recherchePieceId(id);
		if(p!=null) {
			servicepiece.modifierPiece(ppiece);
		}
		return ppiece;
	}
	
	/**
	 * Methode mapper sur /RestPiece/Pieces
	 * Permettant d'ajouter une Piece en bdd
	 * @param ppiece correpond au données de la Piece
	 * @return La piece ajoute en bdd
	 */
	@PostMapping("/Pieces")
	public Piece addPiece(@RequestBody Piece ppiece) {
		servicepiece.creerPiece(ppiece);
		return ppiece;
	}
	
}
