import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CommercialComponent } from './commercial.component';
import { CommandeVehiculeComponent } from './commande-vehicule/commande-vehicule.component';
import { VehiculeComponent } from './vehicule/vehicule.component';
import { FactureDevisComponent } from './facture-devis/facture-devis.component';
import { HeaderCommercialComponent } from './header-commercial/header-commercial.component';



@NgModule({
  declarations: [
    CommercialComponent,
    CommandeVehiculeComponent,
    VehiculeComponent,
    FactureDevisComponent,
    HeaderCommercialComponent
  ],
  imports: [
    CommonModule,
    
  ],
  exports: [
    CommercialComponent
  ],
  bootstrap:[CommercialComponent]
})
export class CommercialModule { }
