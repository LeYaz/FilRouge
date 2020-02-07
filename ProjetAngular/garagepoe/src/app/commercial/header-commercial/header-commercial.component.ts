import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'gar-header-commercial',
  templateUrl: './header-commercial.component.html',
  styleUrls: ['./header-commercial.component.css']
})
export class HeaderCommercialComponent implements OnInit {

  constructor(private route:ActivatedRoute, private router: Router) { }

  ngOnInit() {
  }

  showCmdVehicule(){
    this.router.navigate(['commande-vehicule'], {relativeTo: this.route});
  }

  showFactureDevis(){
    this.router.navigate(['facture-devis'], {relativeTo: this.route});
  }

  showVehicules(){
    this.router.navigate(['vehicule'], {relativeTo: this.route});
  }
}
