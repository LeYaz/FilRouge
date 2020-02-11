import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PiecesEditComponent } from './pieces-edit.component';

describe('PiecesEditComponent', () => {
  let component: PiecesEditComponent;
  let fixture: ComponentFixture<PiecesEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PiecesEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PiecesEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
