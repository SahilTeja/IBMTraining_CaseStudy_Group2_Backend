import { TestBed } from '@angular/core/testing';

import { HomeLoanService } from './home-loan.service';

describe('HomeLoanService', () => {
  let service: HomeLoanService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HomeLoanService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
