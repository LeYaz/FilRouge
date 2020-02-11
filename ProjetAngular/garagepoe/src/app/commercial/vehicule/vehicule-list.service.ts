import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class VehiculeListService {


  private url: string = 'http://localhost:8080/RestVehicule/Vehicules';


  constructor(private http: HttpClient) {
   }

   getVehicules() {
     return this.http.get(this.url);
   }


   getVehiculesId(id: number) {
    return this.http.get(this.url + '/' + id);
  }

   deleteVehiculesId(id: number) {
    return this.http.delete(this.url + '/' + id);
  }

  editVehiculeId(id: number) {
//    return this.http.put(this.url);
  }

  // get(id: number) {
  //   let veh1: Vehicule;
  //   this.vehiculelist.filter( element => {
  //     if (element.id === id) {
  //       veh1 = element;
  //     }
  //   });
  //   return veh1;
  // }

  // getNewId(){
  //   let id: number = this.vehiculelist.length + 1;
  //   return id++;
  // }

  // add(vehicule: Vehicule){
  //   vehicule.id = this.getNewId();
  //   this.vehiculelist.push(vehicule);
  // }

  // edit(vehicule: Vehicule){
  //   this.get(vehicule.id).marque = vehicule.marque;
  //   this.get(vehicule.id).modele = vehicule.modele;
  //   this.get(vehicule.id).quantite = vehicule.quantite;
  //   this.get(vehicule.id).prixHT = vehicule.prixHT;
  //   this.get(vehicule.id).datecreation = vehicule.date_creation;
  //   this.get(vehicule.id).desactiver = vehicule.desactiver;
  // }

  // deactive(id: number) {
  //   for ( let i = 0; i < this.vehiculelist.length; i++) {
  //     if (this.vehiculelist[i].id == id) {
  //         this.vehiculelist.splice(i);
  //     }
  //   }
  // }
}
