import { Component, OnInit } from '@angular/core';

import { Vehicule } from './vehicule.model';
import { VehiculeListService } from './vehicule-list.service';
import { Router, ActivatedRoute } from '@angular/router';
import { element } from 'protractor';
import { relative } from 'path';

@Component({
  selector: 'gar-vehicule',
  templateUrl: './vehicule.component.html',
  styleUrls: ['./vehicule.component.css']
})
export class VehiculeComponent implements OnInit {

  vehiculelist: Vehicule[] = new Array();
  
  constructor(private vehiculelistservice: VehiculeListService, private route: Router, private actroute: ActivatedRoute) { }

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

        let v:Vehicule = new Vehicule(id, marque, modele,quantite, prixHT, datecreation, desactiver);
        
        this.vehiculelist.push(v);
      });

    });
  }



  editVehicule(id: number) {
    this.route.navigate(['edit/' + id], {relativeTo: this.actroute});
  }

  deleteVehicule(id: number) {
    this.vehiculelistservice.deleteVehiculesId(id).subscribe(d => {
      this.vehiculelist = [];
      this.ngOnInit();
    });
  }

}
