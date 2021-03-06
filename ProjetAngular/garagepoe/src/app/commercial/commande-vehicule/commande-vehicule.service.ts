import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommandeVehicule } from './commande-vehicule-model';

@Injectable({
  providedIn: 'root'
})
  export class CommandeVehiculeService {

    private url: string = 'http://localhost:8080/RestCommandeVehicule/CommandeVehicule';

    commandevehiculelist: CommandeVehicule[] = new Array();
    constructor(private http: HttpClient) {

     }

     getCommandeVehicule() {
      return this.http.get(this.url);
    }

     getCommandeVehiculeId(id: number) {
     return this.http.get<CommandeVehicule>(this.url + '/' + id);
   }

    deleteCommandeVehiculeId(id: number) {
     return this.http.delete(this.url + '/' + id);
   }


   editCommandeVehicule(commandeVehicule: CommandeVehicule) {
    let urlput : string = this.url + '/' + commandeVehicule.id;
    return this.http.put<CommandeVehicule>(urlput, commandeVehicule);

            }
      }
  // }
  // //  editCommandeVehiculeId(id: number) {
  // //    return this.http.put(this.url);
  // //  }
  // }
