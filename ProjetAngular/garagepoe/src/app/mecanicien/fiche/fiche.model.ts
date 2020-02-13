import { User } from 'src/app/model-util/user-model';
import { Client } from 'src/app/model-util/client-model';
import { Priorite } from 'src/app/model-util/priorite-model';

export class Fiche{
    id: number;
    user: User;
    client: Client ;
    etatfiche: boolean ;
    priorite: Priorite ;
    datecreation : Date;
    datecloture : Date;
    prixht : number;
    description : string;
    desactiver: boolean ;

    constructor(id: number,
                user: User,
                client: Client,
                etatfiche: boolean,
                priorite: Priorite,
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