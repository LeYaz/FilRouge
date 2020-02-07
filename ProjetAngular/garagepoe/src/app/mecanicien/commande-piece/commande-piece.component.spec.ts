import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CommandePieceComponent } from './commande-piece.component';

describe('CommandePieceComponent', () => {
  let component: CommandePieceComponent;
  let fixture: ComponentFixture<CommandePieceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CommandePieceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CommandePieceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
