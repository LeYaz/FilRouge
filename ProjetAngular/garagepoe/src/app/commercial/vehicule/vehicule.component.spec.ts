import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehiculeComponent } from './vehicule.component';

describe('VehiculeComponent', () => {
  let component: VehiculeComponent;
  let fixture: ComponentFixture<VehiculeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VehiculeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VehiculeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
