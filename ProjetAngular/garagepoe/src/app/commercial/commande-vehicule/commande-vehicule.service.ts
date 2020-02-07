import { Injectable } from '@angular/core';
import { CommandeVehicule } from './commande-vehicule-model';

@Injectable({
    providedIn: 'root'
  })

  export class CommandeVehiculeService {
  private  listComVehicule: CommandeVehicule[] = new Array();

    constructor() { }
    getAll() {

      return  this.listComVehicule ;
    }

    get(id: number) {
      let commandeV;
      for (var i of this.listComVehicule) {
        if(id === i.id) {
            commandeV = i;
        }
      }
      return commandeV;
    }
    getNewId() {
      if(this.listComVehicule.length==0){
        return 1;
      }
      let listId: number[] = new Array();
      for (var i of this.listComVehicule) {
        listId.push(i.id);
      }
      var newId = (Math.max(...listId) + 1);
      return newId;
       }

    add(commandevehicule: CommandeVehicule) {
     let commandeV = new CommandeVehicule(this.getNewId(), commandevehicule.devis, commandevehicule.etat,
     commandevehicule.datecreation,  commandevehicule.datecloture, commandevehicule.desactiver);
     this.listComVehicule.push(commandeV);

     return this.listComVehicule;
  }

  edit(commandevehicule: CommandeVehicule) {
    for (var i of this.listComVehicule) {
    if(commandevehicule.id === i.id) {

    i.devis = commandevehicule.devis;
    i.etat = commandevehicule.etat;
    i.datecreation = commandevehicule.datecreation;
    i.datecloture = commandevehicule.datecloture;
    i.desactiver = commandevehicule.desactiver;
            }
      }
  }
  delete(id: number) {
        const found = this.listComVehicule.findIndex(element => element.id === id)
        this.listComVehicule.splice(found, 1);

  }
  }
