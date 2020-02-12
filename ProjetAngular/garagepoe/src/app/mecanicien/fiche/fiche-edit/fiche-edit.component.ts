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
  fiche : Fiche = new Fiche(0,"","", false, "", new Date(),new Date(),0,"",false);

  constructor(private fichelistserv: FicheService, private router: Router, private actrout: ActivatedRoute) { }

  ngOnInit() {
    
  }

}
