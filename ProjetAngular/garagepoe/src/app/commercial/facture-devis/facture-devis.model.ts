export class FactureDevis {
    id: number;
    devis: number;
    prixht: number ;
    tauxtva: number ;
    datecreation: Date ;
    desactiver: boolean ;

    constructor( id: number,
        devis: number,
                 prixht: number,
                 tauxtva: number,
                 datecreation: Date,
                 desactiver: boolean) {
                    this.id = id;

                    this.devis = devis;
                    this.prixht = prixht;
                    this.tauxtva = tauxtva;
                    this.datecreation = datecreation;
                    this.desactiver = desactiver;
       }
   }
export type FactureDev =  Array<FactureDevis>;
