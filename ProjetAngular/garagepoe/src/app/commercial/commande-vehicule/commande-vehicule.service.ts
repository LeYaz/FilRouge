import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';




@Injectable({
  providedIn: 'root'
})
  export class CommandeVehiculeService {

    private url: string = '../../assets/data/vehicule.json';

    constructor(private http: HttpClient) {

     }
     getCommandeVehicule() {
      return this.http.get(this.url);
    }
  }
