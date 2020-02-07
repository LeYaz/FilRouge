import { Injectable } from '@angular/core';
import { factureDev, FactureDevis } from './facture-devis.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FactureDevisService {
factureDev: factureDev;

private url :string = '../../assets/data/fd.js';

  constructor(private http:HttpClient) {
  }
  public getAll() {
    console.log(this.factureDev);

    return this.factureDev;
  }

  get(id: number) {
    let factureD: FactureDevis;
    this.factureDev.filter(element => {
      if (element.id === id) {
        factureD = element;
      }
    });
    console.log(this.factureDev);
    return factureD;
  }
  public getNewId() {
    let id: number = this.factureDev.length + 1;
    return id + 1;
  }
getDevis(){

  return this.http.get(this.url);

}
}
