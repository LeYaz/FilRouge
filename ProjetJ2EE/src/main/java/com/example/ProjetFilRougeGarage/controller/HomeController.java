package com.example.ProjetFilRougeGarage.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

    @GetMapping("/")
    String index(Principal principal) {
        return "home";
    }
    @GetMapping("/entretien")
    String entretien(Principal principal) {
        return "homeentretien";
    }
    @GetMapping("/vente")
    String vente(Principal principal) {
        return "homevente";
    }
    @GetMapping("/stock")
    String stock(Principal principal) {
        return "homestock";
    }
    @GetMapping("/admin")
    String admin(Principal principal) {
        return "homeadmin";
    }
}
