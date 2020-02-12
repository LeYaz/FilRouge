package com.example.ProjetFilRougeGarage.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetFilRougeGarage.beans.CommandePiece;
import com.example.ProjetFilRougeGarage.service.IServiceCommandePiece;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/RestCommandePiece")
public class CommandePieceControllerRest {
	@Autowired
	private IServiceCommandePiece servicecmd;
	
	@GetMapping("/CommandePieces")
	public List<CommandePiece> getCommandePieces(){
		return servicecmd.rechercherCommandePieceActive();
	}
	
	@GetMapping("/CommandePieces/{id}")
	public CommandePiece getCommandePiece(@PathVariable("id") int id){
		return servicecmd.rechercherCommandePieceId(id);
	}
	
	@DeleteMapping("/CommandePieces/{id}")
	public CommandePiece deletePiece(@PathVariable("id") int id){
		CommandePiece cmdp = servicecmd.rechercherCommandePieceId(id);
		servicecmd.desactiverCommandePiece(cmdp);
		return cmdp;
	}
	
	@PutMapping("/CommandePieces/{id}")
	public CommandePiece updateCommandePiece(@PathVariable("id") int id, @RequestBody CommandePiece pcmdpiece){
		CommandePiece cp = servicecmd.rechercherCommandePieceId(id);
		if(cp!=null) {
			servicecmd.modifierCommandePiece(pcmdpiece);
		}
		return pcmdpiece;
	}
	
	@PostMapping("/CommandePieces")
	public CommandePiece addCommandePiece(@RequestBody CommandePiece pcmdpiece) {
		servicecmd.creerCommandePiece(pcmdpiece);
		
		return pcmdpiece;
	}
}
