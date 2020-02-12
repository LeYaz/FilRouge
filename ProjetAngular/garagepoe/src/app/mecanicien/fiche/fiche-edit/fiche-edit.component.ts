import { Component, OnInit } from '@angular/core';
import { FicheService } from '../fiche.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Fiche } from '../fiche.model';

@Component({
  selector: 'gar-fiche-edit',
  templateUrl: './fiche-edit.component.html',
  styleUrls: ['./fiche-edit.component.css']
})
export class FicheEditComponent implements OnInit {
  fiche : Fiche = new Fiche(0, null,null ,false, "", new Date(),new Date(),0,"",false);

  constructor(private fichelistserv: FicheService, private router: Router, private actrout: ActivatedRoute) { }

  ngOnInit() {
    if (this.actrout.snapshot.paramMap.get('id') != null) {
      this.fichelistserv.get(parseInt(this.actrout.snapshot.paramMap.get('id'))).subscribe(d=>{
        this.fiche = new Fiche(d.id, d.user, d.client, d.etatfiche, 
          d.priorite, d.datecreation, d.datecloture, d.prixht, d.description, d.desactiver);
        console.log(d);
      });
      }
  }

  addFiche(){
    if(this.fiche.id==0){
      this.fiche.desactiver=false;
      this.fichelistserv.addFiche(this.fiche).subscribe();
    }else{
      this.fichelistserv.editFiche(this.fiche).subscribe(d=>{
        console.log(d);
      });
    }
    this.router.navigate(['mecanicien/fiches']);
  }
  
}
