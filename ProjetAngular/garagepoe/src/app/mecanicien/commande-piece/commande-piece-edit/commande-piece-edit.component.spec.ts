import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CommandePieceEditComponent } from './commande-piece-edit.component';

describe('CommandePieceEditComponent', () => {
  let component: CommandePieceEditComponent;
  let fixture: ComponentFixture<CommandePieceEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CommandePieceEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CommandePieceEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
