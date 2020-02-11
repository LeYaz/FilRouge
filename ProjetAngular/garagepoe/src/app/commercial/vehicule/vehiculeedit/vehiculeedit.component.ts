import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { VehiculeListService } from '../vehicule-list.service';
import { Vehicule } from '../vehicule.model';

@Component({
  selector: 'gar-vehiculeedit',
  templateUrl: './vehiculeedit.component.html',
  styleUrls: ['./vehiculeedit.component.css']
})
export class VehiculeeditComponent implements OnInit {

  vehicule: Vehicule;

  constructor(private vehiculelistserv: VehiculeListService, private router: Router, private actrout: ActivatedRoute) { }

  ngOnInit() {
    if (this.actrout.snapshot.paramMap.get('id') == null) {
      this.vehicule = new Vehicule(0,'','',0,0,new Date(),false);
  } else {
      // this.vehicule = this.vehiculelistserv.getVehiculesId(parseInt(this.actrout.snapshot.paramMap.get('id')));
    }
  }

  addVehicule(id: number) {
    if (this.vehicule.id === 0) {
      // this.vehicule.id = this.vehiculelistserv.getVehiculesId();
      // this.vehiculelistserv.editVehiculeId(this.vehicule);
    }
    this.router.navigate(['/list']);
  }

}
