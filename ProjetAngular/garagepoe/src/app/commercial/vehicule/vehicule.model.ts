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
                prixHT: number,
                date_creation: Date,
                desactiver: boolean) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.quantite = quantite;
        this.prixHT = prixHT;
        this.date_creation = date_creation;
        this.desactiver = desactiver;
    }
}

//export type Vehicules = Array<Vehicule>;
