import { Pipe, PipeTransform } from '@angular/core';
import { Piece } from './mecanicien/pieces/pieces.model';

@Pipe({
  name: 'recherche'
})
export class RecherchePipe implements PipeTransform {

  transform(piece: Piece[], searchText: string): any[] {
    if(!piece) return [];
    if(!searchText) return piece;

    searchText = searchText.toLowerCase();

    return piece.filter(it => {
      return it.libelle.toLowerCase().includes(searchText);
    });
  }

}
