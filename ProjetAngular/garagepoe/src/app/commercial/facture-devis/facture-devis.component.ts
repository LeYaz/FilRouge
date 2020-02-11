import { Component, OnInit, Input } from '@angular/core';
import { FactureDevis, FactureDev } from './facture-devis.model';
import { FactureDevisService } from './facture-devis.service';
@Component({
  selector: 'gar-facture-devis',
  templateUrl: './facture-devis.component.html',
  styleUrls: ['./facture-devis.component.css']
})
export class FactureDevisComponent implements OnInit {
  FactureDev: FactureDevis[] = new Array();

  constructor(private FactureS: FactureDevisService) { }

  /*
  ngOnInit() {
    this.FactureDev = this.FactureS.getAll();
   }


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
 */


ngOnInit() {
  let list;
  this.FactureS.getDevis().subscribe(d => {
    console.log("Contenu de l'api :");
    console.log(d);
     list = d;
    list.forEach(element => {
      let id = element.id;
      let devis = element.devis;
      let  prixht = element.prixht;
      let tauxtva = element.tauxtva;
      let datecreation = element.datecreation;
      let desactiver = element.desactiver;
      let facture = new FactureDevis(id, devis, prixht, tauxtva, datecreation, desactiver);
      this.FactureDev.push(facture);
     //  this.pokemons.push(pokemon); 

    });

  });
}
}
