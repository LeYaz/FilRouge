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




ngOnInit() {
  let list;
  this.FactureS.getDevis().subscribe(d => {
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
