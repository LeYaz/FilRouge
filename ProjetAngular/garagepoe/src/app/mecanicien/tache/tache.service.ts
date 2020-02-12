import { HttpClient } from '@angular/common/http';

export class TacheService {

    private url: string = 'http://localhost:8080/RestTache/Taches/';

    constructor(private http: HttpClient) { }

    getTache() {
        return this.http.get(this.url);
      }
}