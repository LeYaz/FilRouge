import { Component, OnInit } from '@angular/core';
import { Devis } from 'src/app/model-util/devis-model';

@Component({
  selector: 'gar-commande-vehicule',
  templateUrl: './commande-vehicule.component.html',
  styleUrls: ['./commande-vehicule.component.css']
})
export class CommandeVehiculeComponent implements OnInit {

id: number;
devis: Devis;
etat: boolean;
datecreation: Date;
datecloture: Date;
desactiver: boolean;

  constructor(id: number, devis: Devis, etat: boolean, datecreation: Date, datecloture: Date, desactiver: boolean) {
this.id = id;
this.devis = devis;
this.etat = etat;
this.datecreation = datecreation;
this.datecloture = datecloture;
this.desactiver = desactiver;

   }

  ngOnInit() {
  }

}
