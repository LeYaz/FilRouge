import { TestBed } from '@angular/core/testing';

import { FicheService } from './fiche.service';

describe('FicheService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FicheService = TestBed.get(FicheService);
    expect(service).toBeTruthy();
  });
});
