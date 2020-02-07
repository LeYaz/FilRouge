import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderMecanicienComponent } from './header-mecanicien.component';

describe('HeaderMecanicienComponent', () => {
  let component: HeaderMecanicienComponent;
  let fixture: ComponentFixture<HeaderMecanicienComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderMecanicienComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderMecanicienComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
