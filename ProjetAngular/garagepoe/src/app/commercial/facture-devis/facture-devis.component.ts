import { Component, OnInit } from '@angular/core';
import { FactureDevis, factureDev } from './facture-devis.model';
import { FactureDevisService } from './facture-devis.service';
import data from '../../../assets/data/fd.js';
@Component({
  selector: 'gar-facture-devis',
  templateUrl: './facture-devis.component.html',
  styleUrls: ['./facture-devis.component.css']
})
export class FactureDevisComponent implements OnInit {
  FactureDev: factureDev;

  constructor(private FactureS: FactureDevisService) { }

  ngOnInit() {
    this.FactureDev = this.FactureS.getAll();
   }

}
