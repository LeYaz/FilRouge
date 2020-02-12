import { Component, OnInit } from '@angular/core';
import { Tache } from './tache.model';
import { TacheService } from './tache.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'gar-tache',
  templateUrl: './tache.component.html',
  styleUrls: ['./tache.component.css']
})
export class TacheComponent implements OnInit {
tacheslist: Tache[] = new Array();

constructor(private tacheService: TacheService, private route: Router, private activateroute: ActivatedRoute) { }


ngOnInit() {
  let list;
  this.tacheService.getTache().subscribe(t => {
  list = t;
  console.log(t);
  list.forEach(element => {
let id = element.id;
let commentaire = element.commentaire;
let user = element.user;
let fiche = element.fiche;
let priorite = element.priorite;
let piece = element.piece;
let qte = element.qte;
let etattache = element.etattache;
let desactiver = element.desactiver;
let tache = new Tache(id, commentaire, user, fiche, priorite, piece, qte, etattache, desactiver);
this.tacheslist.push(tache); });

    });
}


editTache(id: number) {
  this.route.navigate(['edit/' + id], {relativeTo: this.activateroute});
}

deleteTache(id: number) {
  this.tacheService.deleteTacheId(id).subscribe(d => {
    this.tacheslist = [];
    this.ngOnInit();
  });
}
}
