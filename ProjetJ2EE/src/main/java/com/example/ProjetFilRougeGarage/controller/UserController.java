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

	private User convertForm(UserForm userform) throws Exception {
		User puser = new User();
		List<Profil> pList = new ArrayList<Profil>();

		for (String pprofil : userform.getProfils()) {
			System.err.println(pprofil);
			pList.add(serviceprofil.rechercherProfilId(Integer.valueOf(pprofil)));
			
			
		}

		puser.setProfils(pList);
//		List<Profil> pListbis = serviceprofil.rechercherProfil();

		puser.setProfils(pList);
		puser.setId(userform.getId());
		puser.setLogin(userform.getLogin());
		puser.setNom(userform.getNom());
		puser.setPrenom(userform.getPrenom());
		puser.setPwd(userform.getPwd());
		puser.setDesactiver(false);

		return puser;
	}

	@GetMapping("/afficherCreerUser")
	public String getAffiche(Model pmodel) {
		List<User> luser = serviceuser.rechercherUserActive();
		List<Profil> lprofil = serviceprofil.rechercherProfil();

		pmodel.addAttribute("listeuser", luser);
		pmodel.addAttribute("listeprofil", lprofil);
		pmodel.addAttribute("action", "CreerUser");
		if (pmodel.containsAttribute("userform") == false) {
			UserForm userform = new UserForm();
			userform.setId(0);
			pmodel.addAttribute("userform", userform);
		}

		return "users";
	}

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

	@GetMapping("/DesactiverUser/{id}")
	public String getDesactiver(@PathVariable final Integer id, Model pmodel) {
		User puser = serviceuser.rechercherUserId(id);
		if (puser != null) {
			serviceuser.desactiverUser(puser);
		}
		return this.getAffiche(pmodel);
	}

	@PostMapping("/CreerUser")
	public String ajoutUser(@Valid @ModelAttribute(name = "userform") UserForm userform, BindingResult presult,
			Model pmodel) {
		System.err.println("convertion du user");
		System.err.println(presult);
		System.err.println(userform.getProfils());
		if (!presult.hasErrors()) {
			try {
				System.err.println("convertion du user");
				User puser = convertForm(userform);
				serviceuser.creerUser(puser);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}

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
