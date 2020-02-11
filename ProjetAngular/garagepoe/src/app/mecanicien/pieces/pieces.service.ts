import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Piece } from './pieces.model';
import { identifierModuleUrl } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class PiecesService {

  private url: string = 'http://localhost:8080/RestPiece/Pieces/';

  constructor(private http: HttpClient) { }

  getPieces(){
    return this.http.get(this.url);
  }

  deletePiece(id:number){
    console.log(this.url+id)
   return this.http.delete(this.url+id);
  }

  editPiece(piece : Piece){
    let urlput : string = this.url+piece.id;
    return this.http.put<Piece>(urlput, piece);
  }

  get(id:number){
    return this.http.get(this.url+id);
  }

  
}
