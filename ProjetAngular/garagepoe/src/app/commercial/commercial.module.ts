import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '.././app-routing.module';
import { CommercialComponent } from './commercial.component';
import { CommandeVehiculeComponent } from './commande-vehicule/commande-vehicule.component';
import { VehiculeComponent } from './vehicule/vehicule.component';
import { FactureDevisComponent } from './facture-devis/facture-devis.component';
import { HeaderCommercialComponent } from './header-commercial/header-commercial.component';
import { CommercialRoutingModule } from './commercial-routing.module'



@NgModule({
  declarations: [
    CommercialComponent,
    CommandeVehiculeComponent,
    VehiculeComponent,
    FactureDevisComponent,
    HeaderCommercialComponent
  ],
  imports: [
    CommercialRoutingModule,
    CommonModule

    
  ],

  bootstrap:[CommercialComponent]
})
export class CommercialModule { }
