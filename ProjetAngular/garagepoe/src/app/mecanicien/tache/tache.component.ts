import { Component, OnInit } from '@angular/core';
import { Tache } from './tache.model';
import { TacheService } from './tache.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'gar-tache',
  templateUrl: './tache.component.html',
  styleUrls: ['./tache.component.css']
})
export class TacheComponent implements OnInit {
tacheslist: Tache[] = new Array();

constructor(private tacheService: TacheService, private route: Router, private activateroute: ActivatedRoute) { }


ngOnInit(): void {
  let list;
  this.tacheService.getTache().subscribe(t => {
  list = t;
  list.forEach(element => {
const id = element.id;
const devis = element.devis;
const etat = element.etat;
const datecreation = element.datecreation;
const datecloture = element.datecloture;
const desactiver = element.desactiver;
const commandV = new CommandeVehicule(id, devis, etat, datecreation, datecloture, desactiver);
this.tacheslist.push(commandV); });

    });
}


editCommandeVehicule(id: number) {
  this.route.navigate(['edit/' + id], {relativeTo: this.activateroute});
}

deleteCommandeVehicule(id: number) {
  this.commandeVehiculeService.deleteCommandeVehiculeId(id).subscribe(d => {
    this.commandevehiculelist = [];
    this.ngOnInit();
  });
}