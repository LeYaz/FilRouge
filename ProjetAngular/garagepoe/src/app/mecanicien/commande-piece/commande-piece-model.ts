import { User } from 'src/app/model-util/user-model';
import { Piece } from '../pieces/pieces.model';

export class CommandePiece {

  id: number;
  user: User;
  piece: Piece;
  quantite: number;
  date_creation: Date;
  date_cloture: Date;
  desactiver: boolean;

  constructor(id: number, user: User, piece: Piece, quantite: number, date_creation: Date, date_cloture: Date, desactiver: boolean) {
    this.id = id;
    this.user = user;
    this.piece = piece;
    this.quantite = quantite;
    this.date_creation = date_creation;
    this.date_cloture = date_cloture;
    this.desactiver = desactiver;
  }
}