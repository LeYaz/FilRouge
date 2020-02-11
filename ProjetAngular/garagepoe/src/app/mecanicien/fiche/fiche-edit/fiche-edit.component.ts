import { Component, OnInit } from '@angular/core';
import { FicheService } from '../fiche.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'gar-fiche-edit',
  templateUrl: './fiche-edit.component.html',
  styleUrls: ['./fiche-edit.component.css']
})
export class FicheEditComponent implements OnInit {

  constructor(private fichelistserv: FicheService, private router: Router, private actrout: ActivatedRoute) { }

  ngOnInit() {
    
  }

}
