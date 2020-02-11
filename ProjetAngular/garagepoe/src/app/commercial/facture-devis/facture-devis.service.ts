import { Injectable } from '@angular/core';
import { FactureDev, FactureDevis } from './facture-devis.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FactureDevisService {
FactureDev: FactureDev;

//private url :string = '../../assets/data/fd.json';
private url: string = 'http://localhost:8080/RestFactureDevis/FactureDevis';
  constructor(private http:HttpClient) {
  }
  public getAll() {
    console.log(this.FactureDev);

    return this.FactureDev;
  }

  get(id: number) {
    let factureD: FactureDevis;
    this.FactureDev.filter(element => {
      if (element.id === id) {
        factureD = element;
      }
    });
    console.log(this.FactureDev);
    return factureD;
  }
  public getNewId() {
    let id: number = this.FactureDev.length + 1;
    return id + 1;
  }
getDevis(){

  return this.http.get(this.url);

}
}
