import { Injectable } from '@angular/core';
import { factureDev, FactureDevis } from './facture-devis.model';

@Injectable({
  providedIn: 'root'
})
export class FactureDevisService {
factureDevF: factureDev;

  constructor() {
    this.factureDevF = new Array();
  }
  public getAll() {
    return this.factureDevF;
  }

  get(id: number) {
    let factureD: FactureDevis;
    this.factureDevF.filter(element => {
      if (element.id === id) {
        factureD = element;
      }
    });
    return factureD;
  }
  public getNewId() {
    let id: number = this.factureDevF.length + 1;
    return id + 1;
  }

}
