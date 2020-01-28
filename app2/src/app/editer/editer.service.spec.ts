import { TestBed, inject } from '@angular/core/testing';

import { EditerService } from './editer.service';

describe('EditerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EditerService]
    });
  });

  it('should be created', inject([EditerService], (service: EditerService) => {
    expect(service).toBeTruthy();
  }));
});
