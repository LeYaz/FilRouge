export class Piece {
    id: number;
    libelle: string;
    quantite:number;
    date_saisie:Date;
    desactiver:boolean;

    constructor(id: number, libelle: string, quantite:number, date_saisie:Date, desactiver:boolean){
        this.id = id;
        this.libelle = libelle;
        this.quantite = quantite;
        this.date_saisie = date_saisie;
        this.desactiver = desactiver;
    }
}