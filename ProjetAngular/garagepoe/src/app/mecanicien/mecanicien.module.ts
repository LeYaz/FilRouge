import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MecanicienComponent } from './mecanicien.component';
import { TacheComponent } from './tache/tache.component';
import { FicheComponent } from './fiche/fiche.component';
import { PiecesComponent } from './pieces/pieces.component';
import { CommandePieceComponent } from './commande-piece/commande-piece.component';
import { HeaderMecanicienComponent } from './header-mecanicien/header-mecanicien.component';
import { MecanicienRoutingModule } from './mecanicien-routing.module';
import { FicheEditComponent } from './fiche/fiche-edit/fiche-edit.component';



@NgModule({
  declarations: [
    MecanicienComponent,
    TacheComponent,
    FicheComponent,
    PiecesComponent,
    CommandePieceComponent,
    HeaderMecanicienComponent,
    FicheEditComponent
  ],
  imports: [
    MecanicienRoutingModule,
    CommonModule
  ],
  bootstrap: [MecanicienComponent]
})
export class MecanicienModule { }
