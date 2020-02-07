import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MecanicienComponent } from './mecanicien/mecanicien.component';
import { CommercialComponent } from './commercial/commercial.component';
import { CommandePieceComponent } from './mecanicien/commande-piece/commande-piece.component';
import { FicheComponent } from './mecanicien/fiche/fiche.component';
import { PiecesComponent } from './mecanicien/pieces/pieces.component';
import { TacheComponent } from './mecanicien/tache/tache.component';
import { CommandeVehiculeComponent } from './commercial/commande-vehicule/commande-vehicule.component';
import { FactureDevisComponent } from './commercial/facture-devis/facture-devis.component';
import { VehiculeComponent } from './commercial/vehicule/vehicule.component';

const routes: Routes = [
  {path: 'mecanicien', component: MecanicienComponent,
    children:[
      {path:'commande-piece', component: CommandePieceComponent},
      {path:'fiches', component: FicheComponent},
      {path:'pieces', component: PiecesComponent},
      {path:'taches', component: TacheComponent}
    ]
},
  {path: 'commercial', component: CommercialComponent,
    children:[
      {path:'commande-vehicule', component: CommandeVehiculeComponent},
      {path:'facture-devis', component: FactureDevisComponent},
      {path:'vehicule', component: VehiculeComponent}
    ]
},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
