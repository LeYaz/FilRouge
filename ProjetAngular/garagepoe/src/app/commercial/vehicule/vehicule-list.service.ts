import { Injectable } from '@angular/core';
import { Vehicules, Vehicule } from './vehicule.model';
import { element } from 'protractor';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class VehiculeListService {


  private url: string = "../../assets/data/vehicule.json";

  vehiculelist: Vehicules;

  constructor(private http: HttpClient) {
    this.vehiculelist = new Array();
   }

   getVehicules(){
     return this.http.get(this.url);
   }

  getAll() {
    return this.vehiculelist;
  }

  get(id: number) {
    let veh1: Vehicule;
    this.vehiculelist.filter( element => {
      if (element.id === id) {
        veh1 = element;
      }
    });
    return veh1;
  }

  getNewId(){
    let id: number = this.vehiculelist.length + 1;
    return id++;
  }

  add(vehicule: Vehicule){
    vehicule.id = this.getNewId();
    this.vehiculelist.push(vehicule);
  }

  edit(vehicule: Vehicule){
    this.get(vehicule.id).marque = vehicule.marque;
    this.get(vehicule.id).modele = vehicule.modele;
    this.get(vehicule.id).quantite = vehicule.quantite;
    this.get(vehicule.id).prixHT = vehicule.prixHT;
    this.get(vehicule.id).datecreation = vehicule.datecreation;
    this.get(vehicule.id).desactiver = vehicule.desactiver;
  }

  deactive(id: number) {
    for ( let i = 0; i < this.vehiculelist.length; i++) {
      if (this.vehiculelist[i].id == id) {
        // ici faire la desactivation du vehicule
      }
    }
  }
}
