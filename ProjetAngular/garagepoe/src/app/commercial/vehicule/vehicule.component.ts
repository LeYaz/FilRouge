import { Component, OnInit } from '@angular/core';
import { Vehicule } from './vehicule.model';
import { VehiculeListService } from './vehicule-list.service';
import { Router, ActivatedRoute } from '@angular/router';

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
      console.log(d);
      list = d;
      list.forEach(element => {
        const id = element.id;
        const marque = element.marque;
        const  modele = element.modele;
        const quantite = element.quantite;
        const prixht = element.prixht;
        const datecreation = element.datecreation;
        const desactiver = element.desactiver;

        const v: Vehicule = new Vehicule(id, marque, modele, quantite, prixht, datecreation, desactiver);
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

  addVehicule(){
    this.route.navigate(['edit/'], {relativeTo: this.actroute});
  }

}
