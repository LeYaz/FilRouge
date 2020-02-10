import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CommandePieceComponent } from './commande-piece/commande-piece.component';
import { FicheComponent } from './fiche/fiche.component';
import { PiecesComponent } from './pieces/pieces.component';
import { TacheComponent } from './tache/tache.component';
import { MecanicienComponent } from './mecanicien.component';

const routes: Routes = [
  { path: 'mecanicien', component: MecanicienComponent,
  children: [
    {path:'commande-piece', component: CommandePieceComponent},
    {path:'fiches', component: FicheComponent},
    {path:'pieces', component: PiecesComponent},
    {path:'taches', component: TacheComponent}
  ] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class MecanicienRoutingModule { }