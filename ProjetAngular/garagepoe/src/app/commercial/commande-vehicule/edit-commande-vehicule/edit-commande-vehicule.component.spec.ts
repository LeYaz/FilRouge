import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCommandeVehiculeComponent } from './edit-commande-vehicule.component';

describe('EditCommandeVehiculeComponent', () => {
  let component: EditCommandeVehiculeComponent;
  let fixture: ComponentFixture<EditCommandeVehiculeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditCommandeVehiculeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditCommandeVehiculeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
