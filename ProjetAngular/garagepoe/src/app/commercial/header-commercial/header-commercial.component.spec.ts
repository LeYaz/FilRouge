import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderCommercialComponent } from './header-commercial.component';

describe('HeaderCommercialComponent', () => {
  let component: HeaderCommercialComponent;
  let fixture: ComponentFixture<HeaderCommercialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderCommercialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderCommercialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
