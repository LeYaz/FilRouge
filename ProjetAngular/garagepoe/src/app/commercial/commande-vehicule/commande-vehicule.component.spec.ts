import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CommandeVehiculeComponent } from './commande-vehicule.component';

describe('CommandeVehiculeComponent', () => {
  let component: CommandeVehiculeComponent;
  let fixture: ComponentFixture<CommandeVehiculeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CommandeVehiculeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CommandeVehiculeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
