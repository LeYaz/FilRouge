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

  this.commandeVehiculeService.getCommandeVehiculeId(parseInt(this.activatedRoute.snapshot.paramMap.get('id')));
  }

  editCommandeVehicule() {
 
  this.commandeVehiculeService.editCommandeVehicule(this.commandeVehicule);
}
    //this.router.navigate(['/Edit']);
  }

//}
