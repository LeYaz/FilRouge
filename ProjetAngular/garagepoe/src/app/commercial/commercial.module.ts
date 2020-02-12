import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '.././app-routing.module';
import { CommercialComponent } from './commercial.component';
import { CommandeVehiculeComponent } from './commande-vehicule/commande-vehicule.component';
import { VehiculeComponent } from './vehicule/vehicule.component';
import { FactureDevisComponent } from './facture-devis/facture-devis.component';
import { HeaderCommercialComponent } from './header-commercial/header-commercial.component';
import { CommercialRoutingModule } from './commercial-routing.module';
import { VehiculeeditComponent } from './vehicule/vehiculeedit/vehiculeedit.component'
import { FormsModule } from '@angular/forms';
import { EditCommandeVehiculeComponent } from './commande-vehicule/edit-commande-vehicule/edit-commande-vehicule.component'
import { RechercheVPipe } from '../recherche-v.pipe';


@NgModule({
  declarations: [
    CommercialComponent,
    CommandeVehiculeComponent,
    VehiculeComponent,
    FactureDevisComponent,
    HeaderCommercialComponent,
    VehiculeeditComponent,
    EditCommandeVehiculeComponent,
    RechercheVPipe
  ],
  imports: [
    CommercialRoutingModule,
    CommonModule,
    FormsModule


    
  ],

  bootstrap:[CommercialComponent]
})
export class CommercialModule { }
