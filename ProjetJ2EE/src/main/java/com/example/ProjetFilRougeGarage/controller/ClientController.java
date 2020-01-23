package com.example.ProjetFilRougeGarage.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ProjetFilRougeGarage.beans.Client;
import com.example.ProjetFilRougeGarage.controller.form.ClientForm;
import com.example.ProjetFilRougeGarage.service.IServiceClient;


/**
 * 
 * @author Teddy
 *
 */
@Controller
public class ClientController {

	/**
	 * Déclaration du service
	 */
	@Autowired
	private IServiceClient serviceclient;
	
	/**
 * Le ConvertForm permet de récupérer le formulaire saisi pour la création
 * et modification de données
	 * @param clientform : les données à récupérer du formulaire Client
	 * @return le client crée ou modifié
	 * @throws Exception
	 */
	private Client convertForm(ClientForm clientform) throws Exception {
		Client cl = new Client();
		
		cl.setId(clientform.getId());
		cl.setName(clientform.getName());
		cl.setFirstname(clientform.getFirstname());
		cl.setAdresse(clientform.getAdresse());
		cl.setCodepostal(clientform.getCodepostal());
		cl.setVille(clientform.getVille());
		cl.setTel(clientform.getTel());
		cl.setPortable(clientform.getPortable());
		cl.setDesactiver(Boolean.valueOf(clientform.getDesactiver()));
		
		return cl;
	}
	
	/**
	 * Affiche la liste des clients actifs de la base de données et le formulaire
	 * de creation de client.On les affiche dans la liste
	 * @param pmodel
	 * @return
	 */
	@GetMapping("/afficherCreerClient")
	public String getAffiche(Model pmodel) {
		List<Client> lclient = serviceclient.rechercheClientActive();
		pmodel.addAttribute("listeclient", lclient);
		pmodel.addAttribute("action", "CreerClient");
		if(pmodel.containsAttribute("clientform") == false) {
			ClientForm clientform = new ClientForm();
			clientform.setId(0);
			pmodel.addAttribute("clientform",clientform);
		}
		return "clients";
	}
	
	
	/**
	 * Après être passé par afficherCreerClient, on crée le client à partir du
	 * formulaire récupéré
	 * @param clientform : le formulaire du client recupéré
	 * @param presult : le résultat
	 * @param pmodel : l'affichage de la page et des données
	 * @return la page de la liste des clients actualisée
	 */
	@PostMapping("/CreerClient")
	public String ajoutClasse( 
			@Valid @ModelAttribute(name = "clientform") 
			ClientForm clientform,
			BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Client pclient = convertForm(clientform);
				serviceclient.creerClient(pclient);
			}
			catch(Exception e) {
				
				System.err.println(e.getMessage());
			}
		}
		else
		{
			System.err.println(presult);
		}
		return this.getAffiche(pmodel);
	}
	
	
	@GetMapping("/DesactiverClient/{id}")
	public String getDesativer(@PathVariable final Integer id,Model pmodel) {
		Client pclient = serviceclient.rechercheClientId(id);
		pclient.setDesactiver(true);
		serviceclient.desactiverClient(pclient);
		return this.getAffiche(pmodel);
	}
	
	
	@GetMapping("/afficherModifierClient/{id}")
	public String getAfficheMod(@PathVariable final Integer id,Model pmodel) {
		Client pclient = serviceclient.rechercheClientId(id);
		pmodel.addAttribute("listeclient", null);
		pmodel.addAttribute("action", "ModifierClient");
		if(pmodel.containsAttribute("clientform") == false) {
			ClientForm clientform = new ClientForm();
			clientform.setId(pclient.getId());
			clientform.setName(pclient.getName());
			clientform.setFirstname(pclient.getFirstname());
			clientform.setAdresse(pclient.getAdresse());
			clientform.setCodepostal(pclient.getCodepostal());
			clientform.setVille(pclient.getVille());
			clientform.setTel(pclient.getTel());
			clientform.setPortable(pclient.getPortable());
			pmodel.addAttribute("clientform", clientform);
		}
		return "clients";
	}
	
	@PostMapping("/ModifierClient")
	public String modifieClasse( 
			@Valid @ModelAttribute(name = "clientform") 
			ClientForm clientform,
			 BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Client pclient = convertForm(clientform);
				serviceclient.modifierClient(pclient);
				
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	
}