import { Component, OnInit } from '@angular/core';
import { CommandePieceService } from '../commande-piece.service';
import { Router, ActivatedRoute } from '@angular/router';
import { CommandePiece } from '../commande-piece-model';

@Component({
  selector: 'gar-commande-piece-edit',
  templateUrl: './commande-piece-edit.component.html',
  styleUrls: ['./commande-piece-edit.component.css']
})
export class CommandePieceEditComponent implements OnInit {

  commandepiece: CommandePiece = new CommandePiece(0, null, null, 0, new Date(), new Date(), false);

  constructor(private commandelistservice: CommandePieceService, private router: Router, private route: ActivatedRoute) { }


  ngOnInit() {
    if (this.route.snapshot.paramMap.get('id') != null) {
      this.commandelistservice.get(parseInt(this.route.snapshot.paramMap.get('id'))).subscribe(d => {
        let cp = d;
        this.commandepiece = new CommandePiece(cp.id, cp.user, cp.piece, cp.quantite, cp.date_creation, cp.date_cloture, cp.desactiver);
      });
      } else {
      this.commandepiece = new CommandePiece(0, null, null, 0, new Date(), new Date(), false);
    }
  }

  addCommandePiece() {
    if(this.commandepiece.id==0){
      this.commandepiece.desactiver=false;
      this.commandelistservice.addCommandePiece(this.commandepiece).subscribe();
    }else{
      this.commandelistservice.editCommandePieceId(this.commandepiece).subscribe(d=>{
        console.log(d);
      })
    }
    this.router.navigate(['mecanicien/commandepiece']);
  }

}
