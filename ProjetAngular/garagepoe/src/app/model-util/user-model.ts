import { OnInit } from '@angular/core';

export class User implements OnInit {

    id: number;
    nom: string;
    prenom: string;
    login: string;
    pwd: string;

constructor(id: number, nom: string, prenom: string, login: string, pwd: string) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.login = login;
    this.pwd = pwd;
       }
      ngOnInit() {
      }
    }
