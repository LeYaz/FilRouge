import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditeTacheComponent } from './edite-tache.component';

describe('EditeTacheComponent', () => {
  let component: EditeTacheComponent;
  let fixture: ComponentFixture<EditeTacheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditeTacheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditeTacheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
