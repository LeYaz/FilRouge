import { OnInit } from '@angular/core';

export class Priorite implements OnInit {

    id: number;
    libelle: string;
    desactiver: boolean;

constructor(id: number, libelle: string, desactiver: boolean) {
this.id = id;
this.libelle = libelle;
this.desactiver = desactiver;
}


ngOnInit() {


}

}
