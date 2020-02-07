import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'gar-header-mecanicien',
  templateUrl: './header-mecanicien.component.html',
  styleUrls: ['./header-mecanicien.component.css']
})
export class HeaderMecanicienComponent implements OnInit {

  constructor(private route:ActivatedRoute, private router: Router) { }

  ngOnInit() {
  }

  showCmdPiece(){
    this.router.navigate(['commande-piece'], {relativeTo: this.route});
  }

  showFiches(){
    this.router.navigate(['fiches'], {relativeTo: this.route});
  }

  showPieces(){
    this.router.navigate(['pieces'], {relativeTo: this.route});
  }

  showTaches(){
    this.router.navigate(['taches'], {relativeTo: this.route});
  }
}
