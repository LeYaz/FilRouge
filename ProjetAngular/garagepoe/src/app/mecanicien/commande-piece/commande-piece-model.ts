import { User } from 'src/app/model-util/user-model';
import { Piece } from '../pieces/pieces.model';

export class CommandePiece {

id: number;
user: User;
piece: Piece;
quantite: number;
datecreation: Date;
datecloture: Date;
desactiver: boolean;

  constructor(id: number, user: User, piece: Piece, quantite: number, datecreation: Date, datecloture: Date, desactiver: boolean) {
this.id = id;
this.user = user;
this.piece = piece;
this.datecreation = datecreation;
this.datecloture = datecloture;
this.desactiver = desactiver;
  }
}