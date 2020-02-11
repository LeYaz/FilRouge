import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FicheService {


  private url: string = 'http://localhost:8080/RestFiche/Fiches';


  constructor(private http: HttpClient) {
   }

   getFiches() {
     return this.http.get(this.url);
   }


   getFichesId(id: number) {
    return this.http.get(this.url + '/' + id);
  }

   deleteFicheId(id: number) {
    console.log(this.url+ '/'+ id)
    return this.http.delete(this.url + '/' + id);
  }

  editFicheId(id: number) {
//    return this.http.put(this.url);
  }

}
