import { TestBed } from '@angular/core/testing';

import { VehiculeListService } from './vehicule-list.service';

describe('VehiculeListService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VehiculeListService = TestBed.get(VehiculeListService);
    expect(service).toBeTruthy();
  });
});
