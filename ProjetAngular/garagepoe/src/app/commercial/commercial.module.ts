import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '.././app-routing.module';
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
    BrowserModule,
    AppRoutingModule

  ],
  exports: [
    CommercialComponent,
    CommandeVehiculeComponent,
    VehiculeComponent,
    FactureDevisComponent,
    HeaderCommercialComponent
  ],
  bootstrap: [CommercialComponent]
})
export class CommercialModule { }
