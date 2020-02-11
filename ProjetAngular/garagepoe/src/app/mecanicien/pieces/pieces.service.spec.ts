import { TestBed } from '@angular/core/testing';

import { PiecesService } from './pieces.service';

describe('PiecesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PiecesService = TestBed.get(PiecesService);
    expect(service).toBeTruthy();
  });
});
