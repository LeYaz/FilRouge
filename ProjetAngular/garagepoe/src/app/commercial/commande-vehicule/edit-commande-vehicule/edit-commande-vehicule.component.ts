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
commandeVehicule: CommandeVehicule;


  constructor(private commandeVehiculeService: CommandeVehiculeService, private router: Router, private activatedRoute: ActivatedRoute ) { }

  ngOnInit() {

  this.commandeVehiculeService.getCommandeVehiculeId( parseInt (this.activatedRoute.snapshot.paramMap.get('id') ) );

  if (this.activatedRoute.snapshot.paramMap.get('id') != null) {
    this.commandeVehiculeService.getCommandeVehiculeId (parseInt(this.activatedRoute.snapshot.paramMap.get('id'))).subscribe(d => {
      let cv = d[0];
      this.commandeVehicule = new CommandeVehicule(cv.id, cv.devis, cv.etat, cv.datecreation, cv.datecloture, cv.desactiver);
    });
  } else {
    this.commandeVehicule = new CommandeVehicule(0, null, false, new Date(), new Date(), false );
  }
}

  editCommandeVehicule(id: number) {
 
    this.router.navigate(['edit/' + id], {relativeTo: this.activatedRoute});
  }
  }


