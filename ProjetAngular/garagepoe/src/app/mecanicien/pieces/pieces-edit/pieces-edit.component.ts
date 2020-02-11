import { Component, OnInit } from '@angular/core';
import { Piece } from '../pieces.model';
import { PiecesService } from '../pieces.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'gar-pieces-edit',
  templateUrl: './pieces-edit.component.html',
  styleUrls: ['./pieces-edit.component.css']
})
export class PiecesEditComponent implements OnInit {

  piece : Piece;

  constructor(private servicepiece:PiecesService, private router:Router, private route: ActivatedRoute) { }

  ngOnInit() {
    if(this.route.snapshot.paramMap.get('id')!=null){
      this.servicepiece.get(parseInt(this.route.snapshot.paramMap.get('id'))).subscribe(d=>{
        let p = d[0];
        this.piece = new Piece(p.id, p.libelle, p.quantite, p.date_saisie, p.desactiver);
      });
    }else{
      this.piece = new Piece(0,"",0,new Date(),false );
    }
  }

  addPiece(){

  }
}
