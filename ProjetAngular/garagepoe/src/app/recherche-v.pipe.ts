import { Pipe, PipeTransform } from '@angular/core';
import { Vehicule } from './commercial/vehicule/vehicule.model';

@Pipe({
  name: 'rechercheV'
})
export class RechercheVPipe implements PipeTransform {

  transform(vehicule: Vehicule[], searchText: string): any[] {
    if(!vehicule) return [];
    if(!searchText) return vehicule;

    searchText = searchText.toLowerCase();

    return vehicule.filter(it => {
      return it.marque.toLowerCase().includes(searchText);
    });
  }

}
