export class FactureDevis {
    id: number;
    idDevis: number;
    prixHt: number ;
    tauxTva: number ;
    dateCreation: Date ;
    desactiver: boolean ;

    constructor( id: number,
                 idDevis: number,
                 prixHt: number,
                 tauxTva: number,
                 dateCreation: Date,
                 desactiver: boolean) {
   this.idDevis = idDevis;
   this.prixHt = prixHt;
   this.tauxTva = tauxTva;
   this.dateCreation = dateCreation;
   this.desactiver = desactiver;
       }
   }
export type FactureDev =  Array<FactureDevis>;
