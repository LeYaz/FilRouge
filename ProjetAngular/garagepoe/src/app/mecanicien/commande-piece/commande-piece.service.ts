import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CommandePieceService {

  private url: string = 'http://localhost:8080/RestVehicule/Vehicules';


  // constructor(private http: HttpClient) {
  //  }

  //  getCommandeVehicule() {
  //    return this.http.get(this.url);
  //  }

  //  deleteCommandeVehiculesId(id: number) {
  //   return this.http.delete(this.url + '/' + id);
  // }

  // editCommandeVehiculeId(vehicule: Vehicule) {
  //   const url1: string = this.url + vehicule.id;
  //   return this.http.put<Vehicule>(url1, vehicule);

  // }

  // get(id:number){
  //   return this.http.get<Vehicule>(this.url + '/' + id);
  // }

  // addCommandeVehicule(vehicule: Vehicule ){
  //   return this.http.post<Vehicule>(this.url, vehicule);
  // }
}
