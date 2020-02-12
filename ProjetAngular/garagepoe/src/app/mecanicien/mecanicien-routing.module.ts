import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CommandePieceComponent } from './commande-piece/commande-piece.component';
import { FicheComponent } from './fiche/fiche.component';
import { PiecesComponent } from './pieces/pieces.component';
import { TacheComponent } from './tache/tache.component';
import { MecanicienComponent } from './mecanicien.component';
import { PiecesEditComponent } from './pieces/pieces-edit/pieces-edit.component';
import { CommandePieceEditComponent } from './commande-piece/commande-piece-edit/commande-piece-edit.component';
import { EditeTacheComponent } from './tache/edite-tache/edite-tache.component';

const routes: Routes = [
  { path: 'mecanicien', component: MecanicienComponent,
  children: [
    {path:'commande-piece', component: CommandePieceComponent},
    {path:'commande-piece/edit', component: CommandePieceEditComponent},
    {path:'commande-piece/edit/:id', component: CommandePieceEditComponent},
    {path:'fiches', component: FicheComponent},
    {path:'pieces', component: PiecesComponent},
    {path:'pieces/edit', component:PiecesEditComponent},
    {path:'pieces/edit/:id', component:PiecesEditComponent},

    {path:'taches', component: TacheComponent},
    {path:'taches/edit/:id', component: EditeTacheComponent},

  ] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class MecanicienRoutingModule { }