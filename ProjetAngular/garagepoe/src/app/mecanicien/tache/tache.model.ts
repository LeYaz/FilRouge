import { User } from 'src/app/model-util/user-model';
import { Priorite } from 'src/app/model-util/priorite-model';
import { Fiche } from '../fiche/fiche.model';
import { Piece } from '../pieces/pieces.model';

export class Tache {
    id: number;
    commentaire: string;
    user: User;
    fiche: Fiche;
    priorite: Priorite;
    piece: Piece;
    qte: number;
    etattache: boolean;
    desactiver: boolean;

    constructor( id: number, commentaire: string, user: User, fiche: Fiche,
                 priorite: Priorite, piece: Piece, qte: number, etattache: boolean, desactiver: boolean) {
        this.id = id;
        this.commentaire = commentaire;
        this.user = user;
        this.fiche = fiche;
        this.priorite = priorite;
        this.piece = piece;
        this.qte = qte;
        this.etattache = etattache;
        this.desactiver = desactiver;
    }
}