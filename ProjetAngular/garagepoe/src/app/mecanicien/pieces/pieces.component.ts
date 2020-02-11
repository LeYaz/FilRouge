import { Component, OnInit } from '@angular/core';
import { Piece } from './pieces.model';
import { PiecesService } from './pieces.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'gar-pieces',
  templateUrl: './pieces.component.html',
  styleUrls: ['./pieces.component.css']
})
export class PiecesComponent implements OnInit {

  piecelist : Piece[] = new Array();

  constructor(private pieceservice: PiecesService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    let pieces;
    this.pieceservice.getPieces().subscribe(d =>{
      console.log(d);
      pieces=d;
      pieces.forEach(element => {
        let id = element.id;
        let libelle = element.libelle;
        let quantite = element.quantite;
        let date_saisie = element.date_saisie;
        let desactiver = element.desactiver;

        let p:Piece  = new Piece(id, libelle, quantite, date_saisie, desactiver);

        this.piecelist.push(p);
        
      });
    })
  }

  editPiece(id:number){
    this.router.navigate(['edit/'+id], {relativeTo: this.route});
  }

  deletePiece(id:number){
    this.pieceservice.deletePiece(id).subscribe(d =>{
      this.piecelist = new Array();
      this.ngOnInit();
    });
  }

  addPiece(){
    this.router.navigate(['edit/'], {relativeTo: this.route});
  }

}
