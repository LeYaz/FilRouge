import { TestBed } from '@angular/core/testing';

import { CommandePieceService } from './commande-piece.service';

describe('CommandePieceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CommandePieceService = TestBed.get(CommandePieceService);
    expect(service).toBeTruthy();
  });
});
