import { Component, OnInit, Input } from '@angular/core';
import { FactureDevis, FactureDev } from './facture-devis.model';
import { FactureDevisService } from './facture-devis.service';
import data from '../../../assets/data/fd.js';
@Component({
  selector: 'gar-facture-devis',
  templateUrl: './facture-devis.component.html',
  styleUrls: ['./facture-devis.component.css']
})
export class FactureDevisComponent implements OnInit {
  @Input()  FactureDev: FactureDev= new Array();

  constructor(private FactureS: FactureDevisService) { }

  /*
  ngOnInit() {
    this.FactureDev = this.FactureS.getAll();
   }
*/

ngOnInit() {
  data.forEach(element => {
    let id = element.id;
    let id_Devis = element.id_Devis;
    let prixHT = element.prixHT;
    let tauxTVA = element.tauxTva;
    let date_creation = element.date_creation;
    let desactiver = element.desactiver;
    let factureDev = new FactureDevis(id, id_Devis, prixHT, tauxTVA, date_creation, desactiver);
    this.FactureDev.push(factureDev);
  });
 }
}
