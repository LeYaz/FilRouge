export class Fiche{
    id: number;
    user: string;
    client: string ;
    etatfiche: boolean ;
    priorite: string ;
    datecreation : Date;
    datecloture : Date;
    prixht : number;
    description : string;
    desactiver: boolean ;

    constructor(id: number,
                user: string,
                client: string,
                etatfiche: boolean,
                priorite: string,
                datecreation : Date,
                datecloture : Date,
                prixht : number,
                description : string,
                desactiver: boolean) {
this.id = id;
this.user = user;
this.client = client;
this.etatfiche = etatfiche;
this.priorite = priorite;
this.datecreation = datecreation;
this.datecloture = datecloture;
this.prixht = prixht;
this.description = description;
this.desactiver = desactiver;
}
}