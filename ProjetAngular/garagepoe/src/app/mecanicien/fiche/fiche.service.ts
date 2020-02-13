import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Fiche } from './fiche.model';
import { Router, ActivatedRoute } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class FicheService {



  private url: string = 'http://localhost:8080/RestFiche/Fiches';


  constructor(private http: HttpClient, private route: Router, private actroute: ActivatedRoute) {
   }

   getFiches() {
     return this.http.get(this.url);
   }

   deleteFicheId(id: number) {
    console.log(this.url+ '/'+ id)
    return this.http.delete(this.url +'/'+ id);
  }

  editFiche(fiche: Fiche) {
    const url1: string = this.url + '/' + fiche.id;
    return this.http.put<Fiche>(url1, fiche);
  }
  get(id:number){
    return this.http.get<Fiche>(this.url + '/' + id);
  }

  addFiche(fiche: Fiche) {
    console.log("salut service");
    return this.http.post<Fiche>(this.url, fiche);


  }
}
