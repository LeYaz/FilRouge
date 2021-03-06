import { Component, OnInit } from '@angular/core';
import { CommandePieceService } from './commande-piece.service';
import { Router, ActivatedRoute } from '@angular/router';
import { CommandePiece } from './commande-piece-model';

@Component({
  selector: 'gar-commande-piece',
  templateUrl: './commande-piece.component.html',
  styleUrls: ['./commande-piece.component.css']
})
export class CommandePieceComponent implements OnInit {

  commandepiecelist: CommandePiece[] = new Array();

  constructor(private commandePieceService: CommandePieceService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    let list;
    this.commandePieceService.getCommandePiece().subscribe(cp => {
      list = cp;
      list.forEach(element => {
        const id = element.id;
        const user = element.user;
        const piece = element.piece;
        const quantite = element.quantite;
        const datecreation = element.date_creation;
        const datecloture = element.date_cloture;
        const desactiver = element.desactiver;
        const commandePiece = new CommandePiece(id, user, piece, quantite, datecreation, datecloture, desactiver);
        this.commandepiecelist.push(commandePiece);
        // console.log(cp);
        console.log(commandePiece);
        console.log(this.commandepiecelist);
      });
    });
  }

  editCommandePiece(id: number) {
    this.router.navigate(['edit/' + id], {relativeTo: this.route});
  }

  deleteCommandePiece(id: number) {
    this.commandePieceService.deleteCommandePieceId(id).subscribe(d => {
      this.commandepiecelist = [];
      this.ngOnInit();
    });
  }

  addCommandePiece() {
    this.router.navigate(['edit/'], {relativeTo: this.route});
  }

}
