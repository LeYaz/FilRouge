import { Component, OnInit } from '@angular/core';
import { Devis } from 'src/app/model-util/devis-model';
import { CommandeVehicule } from './commande-vehicule-model';
import { CommandeVehiculeService } from './commande-vehicule.service';
import { Router } from '@angular/router';

@Component({
  selector: 'gar-commande-vehicule',
  templateUrl: './commande-vehicule.component.html',
  styleUrls: ['./commande-vehicule.component.css']
})
export class CommandeVehiculeComponent implements OnInit {

  commandevehiculelist: CommandeVehicule[] = new Array();


  constructor(private commandeVehiculeService: CommandeVehiculeService, private route: Router) { }

  ngOnInit(): void {
    let list;
    this.commandeVehiculeService.getCommandeVehicule().subscribe(cv => {
    list = cv;
    list.forEach(element => {
  const id = element.id;
  const devis = element.devis;
  const etat = element.etat;
  const datecreation = element.datecreation;
  const datecloture = element.datecloture;
  const desactiver = element.desactiver;
  const commandV = new CommandeVehicule(id, devis, etat, datecreation, datecloture, desactiver);
  this.commandevehiculelist.push(commandV); });

      });
  }


  editCommandeVehicule(id: number) {
    this.route.navigate(['/edit/' + id]);
  }

  deleteCommandeVehicule(id: number) {
    this.commandeVehiculeService.deleteCommandeVehiculeId(id).subscribe(d => {
      this.commandevehiculelist = [];
      this.ngOnInit();
    });
  }

}