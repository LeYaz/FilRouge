import { OnInit } from '@angular/core';

export class Client implements OnInit {

    id: number;
    nom: string;
    prenom: string;
    adresse: string;
    codepostale: string;
    ville: string;
    telephone: string;
    mobile: string;
    desactiver: boolean;

constructor(id: number, nom: string, prenom: string, adresse: string,
            codepostale: string, ville: string, telephone: string, mobile: string, desactiver: boolean) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.adresse = adresse;
    this.codepostale = codepostale;
    this.ville = ville;
    this.telephone = telephone;
    this.mobile = mobile;
    this.desactiver = desactiver;
       }
      ngOnInit() {
      }
    }
