import { TestBed } from '@angular/core/testing';

import { FactureDevisService } from './facture-devis.service';

describe('FactureDevisService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FactureDevisService = TestBed.get(FactureDevisService);
    expect(service).toBeTruthy();
  });
});
