import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CommercialComponent } from './commercial.component';
import { CommandeVehiculeComponent } from './commande-vehicule/commande-vehicule.component';
import { FactureDevisComponent } from './facture-devis/facture-devis.component';
import { VehiculeComponent } from './vehicule/vehicule.component';
import { VehiculeeditComponent } from './vehicule/vehiculeedit/vehiculeedit.component';

const routes: Routes = [
  { path: 'commercial', component: CommercialComponent,
  children: [
    {path:'commande-vehicule', component: CommandeVehiculeComponent},
    {path:'facture-devis', component: FactureDevisComponent},
    {path:'vehicule', component: VehiculeComponent},
    {path:'vehicule/edit/:id', component: VehiculeeditComponent}
  ] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CommercialRoutingModule { }