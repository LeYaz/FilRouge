import { Component, OnInit } from '@angular/core';
import { CommandeVehicule } from '../commande-vehicule-model';
import { CommandeVehiculeService } from '../commande-vehicule.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'gar-edit-commande-vehicule',
  templateUrl: './edit-commande-vehicule.component.html',
  styleUrls: ['./edit-commande-vehicule.component.css']
})
export class EditCommandeVehiculeComponent implements OnInit {
commandeVehicule: CommandeVehicule = new CommandeVehicule(0, null, false, new Date(), null, false ) ;


  constructor(private commandeVehiculeService: CommandeVehiculeService, private router: Router, private activatedRoute: ActivatedRoute ) { }

  ngOnInit() {

  // tslint:disable-next-line: radix
 
  if (this.activatedRoute.snapshot.paramMap.get('id') != null) {
    this.commandeVehiculeService.getCommandeVehiculeId (parseInt(this.activatedRoute.snapshot.paramMap.get('id'))).subscribe(d => {
      let cv = d;
      this.commandeVehicule = new CommandeVehicule(cv.id, cv.devis, cv.etat, cv.datecreation, cv.datecloture, cv.desactiver);
    });
  } else {
    this.commandeVehicule = new CommandeVehicule(0, null, false, new Date(), new Date(), false );
  }
}

editCVehicule() {
  this.commandeVehicule.desactiver = false;

  this.commandeVehiculeService.editCommandeVehicule(this.commandeVehicule).subscribe(d => {
    console.log(d);
  })
  this.router.navigate(['commercial/commande-vehicule']);
}
}
  

