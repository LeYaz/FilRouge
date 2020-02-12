
import { Component, OnInit } from '@angular/core';
import { FicheService } from './fiche.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Fiche } from './fiche.model';


@Component({
  selector: 'gar-fiche',
  templateUrl: './fiche.component.html',
  styleUrls: ['./fiche.component.css']
})
export class FicheComponent implements OnInit {

  fichelist: Fiche[] = new Array();
  
  constructor(private fichelistservice: FicheService, private route: Router, private acroute : ActivatedRoute) { }

  ngOnInit() {
    let list;
    this.fichelistservice.getFiches().subscribe(d => {
      console.log("Contenu de l'api :");
      console.log(d);
       list = d;
      list.forEach(element => {
        let id = element.id;
        let client = element.client;
        let  user = element.user;
        let etatfiche = element.etatfiche;
        let priorite = element.priorite;
        let datecreation = element.datecreation;

        let datecloture = element.datecloture;
        let prixht = element.prixht;
        let description = element.description;

        let desactiver = element.desactiver;
        let fiche = new Fiche(id, client, user, etatfiche, priorite, datecreation,datecloture,prixht,description, desactiver);
        this.fichelist.push(fiche);
      });

    });
  }



  editFiche(id:number){
    this.route.navigate(['edit/' + id], {relativeTo: this.acroute});
  }

  deleteFiche(id: number) {
    this.fichelistservice.deleteFicheId(id).subscribe(d => {
      this.fichelist = [];
      this.ngOnInit();
    });
  }
  addFiche() {
    this.route.navigate(['edit/'], {relativeTo: this.acroute});
  }
}
