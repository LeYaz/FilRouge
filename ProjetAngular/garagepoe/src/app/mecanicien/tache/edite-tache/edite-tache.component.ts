import { Component, OnInit } from '@angular/core';
import { Tache } from '../tache.model';
import { TacheService } from '../tache.service';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'gar-edite-tache',
  templateUrl: './edite-tache.component.html',
  styleUrls: ['./edite-tache.component.css']
})
export class EditeTacheComponent implements OnInit {

  tache: Tache = new Tache(0, "", null, null, null, null, 0, false, false);

  constructor(private tacheservice: TacheService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    if(this.route.snapshot.paramMap.get('id') != null) {
      this.tacheservice.get(parseInt(this.route.snapshot.paramMap.get('id'))).subscribe(t => {
        console.log(t)
        let p =t;

        this.tache = new Tache(p.id, p.commentaire, p.user, p.fiche, p.priorite, p.piece, p.qte, p.etattache, p.desactiver);
      });
    } else {
      this.tache = new Tache(0, "", null, null, null, null, 0, false, false);
    }
  }

  addTache() {
    if (this.tache.id == 0) {
      this.tache.desactiver = false;
      this.tacheservice.addTache(this.tache).subscribe();
    } else {
      this.tacheservice.editTache(this.tache).subscribe(d => {
        console.log(d);
      })
    }
    this.router.navigate(['mecanicien/taches']);
  }
}
