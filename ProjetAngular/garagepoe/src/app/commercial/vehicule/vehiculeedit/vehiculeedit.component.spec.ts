import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehiculeeditComponent } from './vehiculeedit.component';

describe('VehiculeeditComponent', () => {
  let component: VehiculeeditComponent;
  let fixture: ComponentFixture<VehiculeeditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VehiculeeditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VehiculeeditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
