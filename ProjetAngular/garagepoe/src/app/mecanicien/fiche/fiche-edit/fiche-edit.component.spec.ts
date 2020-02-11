import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FicheEditComponent } from './fiche-edit.component';

describe('FicheEditComponent', () => {
  let component: FicheEditComponent;
  let fixture: ComponentFixture<FicheEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FicheEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FicheEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
