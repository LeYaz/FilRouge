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

  vehicule: Vehicule = new Vehicule(0, "", "", 0, 0, null, false);

  constructor(private vehiculelistserv: VehiculeListService, private router: Router, private actrout: ActivatedRoute) { }

  ngOnInit() {
    if (this.actrout.snapshot.paramMap.get('id') != null) {
      this.vehiculelistserv.get(parseInt(this.actrout.snapshot.paramMap.get('id'))).subscribe(d=>{
        let v = d;
        this.vehicule = new Vehicule(v.id, v.marque, v.modele, v.quantite, v.prixht, v.datecreation, v.desactiver);
        console.log(d);
        console.log(this.vehicule);
      });
      } else {
      this.vehicule = new Vehicule(0, "","", 0,0, null, false);
    }
  }

  addVehicule() {
    if(this.vehicule.id==0){
      this.vehicule.desactiver=false;
      this.vehiculelistserv.addVehicule(this.vehicule).subscribe();
    }else{
      this.vehiculelistserv.editVehiculeId(this.vehicule).subscribe(d=>{
        console.log(d);
      })
    }
    this.router.navigate(['commercial/vehicule']);
  }


}
