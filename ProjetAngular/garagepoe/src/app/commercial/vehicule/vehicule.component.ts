import { Component, OnInit } from '@angular/core';
import { Vehicules } from './vehicule.model';
import { VehiculeListService } from './vehicule-list.service';
import { Router } from '@angular/router';

@Component({
  selector: 'gar-vehicule',
  templateUrl: './vehicule.component.html',
  styleUrls: ['./vehicule.component.css']
})
export class VehiculeComponent implements OnInit {

  vehiculelist: Vehicules;

  constructor(private vehiculelistservice: VehiculeListService, private route: Router) { }

  ngOnInit() {
    this.vehiculelist = this.vehiculelistservice.getAll();
  }

  editVehicule(id: number) {
    this.route.navigate(['/edit/' + id]);
  }

  deactiveVehicule(id: number){
    // ici faire la desactivation aussi 
  }

}
