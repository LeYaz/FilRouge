package com.example.ProjetFilRougeGarage.controller;

import java.util.ArrayList;
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

import com.example.ProjetFilRougeGarage.beans.Profil;
import com.example.ProjetFilRougeGarage.beans.User;
import com.example.ProjetFilRougeGarage.controller.form.UserForm;
import com.example.ProjetFilRougeGarage.service.iServiceProfil;
import com.example.ProjetFilRougeGarage.service.iServiceUser;

@Controller
public class UserController {

	@Autowired
	private iServiceProfil serviceprofil;

	@Autowired
	private iServiceUser serviceuser;
	
	/**
	 * Methode de convertion des différents valeur entrer dans le formulaire html en Entité User
	 * 
	 * @param userform objet stockant les différentes valeurs entrer dans le formulaire html
	 * @return Une entité User rempli à l'aide des données du formulaire html
	 * @throws Exception
	 */
	private User convertForm(UserForm userform) throws Exception {
		User puser = new User();
		List<Profil> pList = new ArrayList<Profil>();

		for (String pprofil : userform.getProfils()) {
			System.err.println(pprofil);
			pList.add(serviceprofil.rechercherProfilId(Integer.valueOf(pprofil)));

		}

		puser.setProfils(pList);


		puser.setProfils(pList);
		puser.setId(userform.getId());
		puser.setLogin(userform.getLogin());
		puser.setNom(userform.getNom());
		puser.setPrenom(userform.getPrenom());
		puser.setPwd(userform.getPwd());
		puser.setDesactiver(false);

		return puser;
	}
	
	
	/**
	 * Methode d'envoi a la vue la liste des différents User
	 * @param pmodel model permettant de communiquer des données entre la vue et le controller 
	 * @return le nom du template html a afficher
	 */
	@GetMapping("/afficherCreerUser")
	public String getAffiche(Model pmodel) {
		List<User> luser = serviceuser.rechercherUserActive();
		List<Profil> lprofil = serviceprofil.rechercherProfil();

		pmodel.addAttribute("listeuser", luser);
		pmodel.addAttribute("listeprofil", lprofil);
		pmodel.addAttribute("action", "CreerUser");
		if (!pmodel.containsAttribute("userform")){
		UserForm userform = new UserForm();
		userform.setId(0);
		pmodel.addAttribute("userform", userform);
		}
		return "users";
	}

	/**
	 * Methode d'envoi à la vue d'un user afin de modifier les données du user
	 * @param id correspond au user a modifier
	 * @param pmodel model permettant de communiquer des données entre la vue et le controller 
	 * @return le nom du template html a afficher
	 */
	@GetMapping("/afficherModifierUser/{id}")
	public String getAfficheMod(@PathVariable final Integer id, Model pmodel) {
		User puser = serviceuser.rechercherUserId(id);
		List<Profil> lprofil = serviceprofil.rechercherProfil();
		pmodel.addAttribute("listeuser", null);
		pmodel.addAttribute("listeprofil", lprofil);
		pmodel.addAttribute("action", "ModifierUser");
		if (pmodel.containsAttribute("userform") == false) {
			UserForm userform = new UserForm();
			userform.setId(puser.getId());
			userform.setNom(puser.getNom());
			userform.setPrenom(puser.getPrenom());
			userform.setLogin(puser.getLogin());
			userform.setPwd(puser.getPwd());
			List<String> plprofil = new ArrayList<String>();
			for (Profil p : puser.getProfils()) {
				plprofil.add(p.getName());

			}
			userform.setProfils(plprofil);

			pmodel.addAttribute("userform", userform);
		}
		return "users";
	}
	
	/**
	 *  Methode permettant de désactiver un user
	 * @param id correspond au user a desactiver
	 * @param pmodel model permettant de communiquer des données entre la vue et le controller
	 * @return la methode d'affichage des users
	 */
	@GetMapping("/DesactiverUser/{id}")
	public String getDesactiver(@PathVariable final Integer id, Model pmodel) {
		User puser = serviceuser.rechercherUserId(id);
		if (puser != null) {
			serviceuser.desactiverUser(puser);
		}
		return this.getAffiche(pmodel);
	}
	
	/**
	 * Methode permettant de récuperer les données d'un user et de le creer en bdd
	 * 	
	 * @param userform objet stockant les différentes valeurs entrer dans le formulaire html
	 * @param presult Resultat de la requete post 	
	 * @param pmodel model permettant de communiquer des données entre la vue et le controller
	 * @return la methode d'affichage des users
	 */
	@PostMapping("/CreerUser")
	public String ajoutUser(@Valid @ModelAttribute(name = "userform") UserForm userform, BindingResult presult,
			Model pmodel) {
		System.err.println("convertion du user");
		System.err.println(presult);
		System.err.println(userform.getProfils());
		if (!presult.hasErrors()) {
			try {
				System.err.println("convertion du user");
			    userform = new UserForm();
				userform.setId(0);
				pmodel.addAttribute("userform", userform);
				User puser = convertForm(userform);
				serviceuser.creerUser(puser);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	/**
	 * Methode permettant de récuperer les données d'un user et de mettre à jour celle ci en bdd
	 * 
	 * @param userform objet stockant les différentes valeurs entrer dans le formulaire html
	 * @param presult Resultat de la requete post 
	 * @param pmodel model permettant de communiquer des données entre la vue et le controller
	 * @return la methode d'affichage des users
	 */
	@PostMapping("/ModifierUser")
	public String modifieUser(@Valid @ModelAttribute UserForm userform, BindingResult presult, Model pmodel) {
		if (!presult.hasErrors()) {
			try {
				User puser = convertForm(userform);
				serviceuser.modifierUser(puser);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
}
