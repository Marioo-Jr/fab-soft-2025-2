import { TestBed } from '@angular/core/testing';

import { EspacoService } from './espaco.service';

describe('Espaco', () => {
  let service: EspacoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EspacoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
