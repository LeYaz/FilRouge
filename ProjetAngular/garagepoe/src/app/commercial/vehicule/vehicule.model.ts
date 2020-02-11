export class Vehicule {
    id: number;
    marque: string;
    modele: string;
    quantite: number;
    prixHT: number;
    date_creation: Date;
    desactiver: boolean;

    constructor(id: number,
                marque: string,
                modele: string,
                quantite: number,
                prixht: number,
                datecreation: Date,
                desactiver: boolean) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.quantite = quantite;
        this.prixHT = prixht;
        this.date_creation = datecreation;
        this.desactiver = desactiver;
    }
}

//export type Vehicules = Array<Vehicule>;
