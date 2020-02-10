import { OnInit } from '@angular/core';
import { Client } from './client-model';
import { Vehicule } from '../commercial/vehicule/vehicule.model';
import { User } from './user-model';

export class Devis implements OnInit {

    id: number;
    client: Client;
    vehicule: Vehicule;
    user: User;
    etatdevis: boolean;
    datecreation: Date;
    desactiver: boolean;

    constructor(id: number, client: Client, vehicule: Vehicule, user: User, etatdevis: boolean, datecreation: Date, desactiver: boolean) {
    this.id = id;
    this.client = client;
    this.vehicule = vehicule;
    this.user = user;
    this.etatdevis = etatdevis;
    this.datecreation = datecreation;
    this.desactiver = desactiver;

       }

      ngOnInit() {
      }
    }
