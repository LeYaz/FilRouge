import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Vehicule } from './vehicule.model';

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

   deleteVehiculesId(id: number) {
    return this.http.delete(this.url + '/' + id);
  }

  editVehiculeId(vehicule: Vehicule) {
    const url1: string = this.url + vehicule.id;
    return this.http.put<Vehicule>(url1, vehicule);

  }

  get(id:number){
    return this.http.get<Vehicule>(this.url + '/' + id);
  }
}
