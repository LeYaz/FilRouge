import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MecanicienComponent } from './mecanicien/mecanicien.component';
import { CommercialComponent } from './commercial/commercial.component';
// import { MecanicienModule } from './mecanicien/mecanicien.module';
// import { CommercialModule } from './commercial/commercial.module';

const routes: Routes = [
  {path: 'mecanicien', component: MecanicienComponent,},
  {path: 'commercial', component: CommercialComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
