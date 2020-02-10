import { Devis } from 'src/app/model-util/devis-model';

export class CommandeVehicule {

id: number;
devis: Devis;
etat: boolean;
datecreation: Date;
datecloture: Date;
desactiver: boolean;

  constructor(id: number, devis: Devis, etat: boolean, datecreation: Date, datecloture: Date, desactiver: boolean) {
this.id = id;
this.devis = devis;
this.etat = etat;
this.datecreation = datecreation;
this.datecloture = datecloture;
this.desactiver = desactiver;
  }
}
