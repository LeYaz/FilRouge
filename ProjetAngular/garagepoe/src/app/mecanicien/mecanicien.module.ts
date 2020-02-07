import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MecanicienComponent } from './mecanicien.component';
import { TacheComponent } from './tache/tache.component';
import { FicheComponent } from './fiche/fiche.component';
import { PiecesComponent } from './pieces/pieces.component';
import { CommandePieceComponent } from './commande-piece/commande-piece.component';
import { HeaderMecanicienComponent } from './header-mecanicien/header-mecanicien.component';



@NgModule({
  declarations: [
    MecanicienComponent,
    TacheComponent,
    FicheComponent,
    PiecesComponent,
    CommandePieceComponent,
    HeaderMecanicienComponent
  ],
  imports: [
    CommonModule
    
  ],
  exports: [
    MecanicienComponent,
    TacheComponent,
    FicheComponent,
    PiecesComponent,
    CommandePieceComponent,
    HeaderMecanicienComponent
  ],
  bootstrap: [MecanicienComponent]
})
export class MecanicienModule { }
