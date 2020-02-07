import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { MecanicienModule } from './mecanicien/mecanicien.module';
import { CommercialModule } from './commercial/commercial.module';
import { MecanicienComponent } from './mecanicien/mecanicien.component';
import { CommercialComponent } from './commercial/commercial.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MecanicienModule,
    CommercialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
