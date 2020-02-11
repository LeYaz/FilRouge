import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommandePiece } from './commande-piece-model';

@Injectable({
  providedIn: 'root'
})
export class CommandePieceService {

  private url: string = 'http://localhost:8080/RestVehicule/Vehicules';


  commandepiecelist: CommandePiece[] = new Array();

  constructor(private http: HttpClient) {
   }

   getCommandePiece() {
     return this.http.get(this.url);
   }

   deleteCommandePieceId(id: number) {
    return this.http.delete(this.url + '/' + id);
  }

  editCommandePieceId(commandepiece: CommandePiece) {
    const url1: string = this.url + commandepiece.id;
    return this.http.put<CommandePiece>(url1, commandepiece);

  }

  get(id:number){
    return this.http.get<CommandePiece>(this.url + '/' + id);
  }

  addCommandePiece(commandepiece: CommandePiece ){
    return this.http.post<CommandePiece>(this.url, commandepiece);
  }
}
