import { Component, OnInit } from '@angular/core';
import { Vehicule } from './vehicule.model';
import { VehiculeListService } from './vehicule-list.service';
import { Router } from '@angular/router';
import { element } from 'protractor';

@Component({
  selector: 'gar-vehicule',
  templateUrl: './vehicule.component.html',
  styleUrls: ['./vehicule.component.css']
})
export class VehiculeComponent implements OnInit {

  vehiculelist: Vehicule[] = new Array();
  
  constructor(private vehiculelistservice: VehiculeListService, private route: Router) { }

  ngOnInit() {
    let list;
    this.vehiculelistservice.getVehicules().subscribe(d => {
      console.log("Contenu de l'api :");
      console.log(d);
       list = d;
      list.forEach(element => {
        let id = element.id;
        let marque = element.marque;
        let  modele = element.modele;
        let quantite = element.quantite;
        let prixHT = element.prixHT;
        let datecreation = element.datecreation;
        let desactiver = element.desactiver;
        let vehicule = new Vehicule(id, marque, modele, quantite, prixHT, datecreation, desactiver);
        this.vehiculelist.push(vehicule);
       //  this.pokemons.push(pokemon); 
  
      });

    });
  }

  editVehicule(id: number) {
    this.route.navigate(['/edit/' + id]);
  }

  deactiveVehicule(id: number){
    // ici faire la desactivation aussi 
  }

}
