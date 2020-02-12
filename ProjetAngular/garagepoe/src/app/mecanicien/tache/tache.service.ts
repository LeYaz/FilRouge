import { HttpClient } from '@angular/common/http';
import { Tache } from './tache.model';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TacheService {

    private url: string = 'http://localhost:8080/RestTache/Taches/';

    constructor(private http: HttpClient) { }

    getTache() {
        return this.http.get(this.url);
      }
      deleteTacheId(id: number) {
        return this.http.delete(this.url + id);
      }

      editTache(tache : Tache) {
        let urlput : string = this.url + tache.id;
        return this.http.put<Tache>(urlput, tache);
      }

      get(id: number) {
        return this.http.get<Tache>(this.url + id);
      }

      addTache(tache : Tache) {
        return this.http.post<Tache>(this.url, tache);
      }
}