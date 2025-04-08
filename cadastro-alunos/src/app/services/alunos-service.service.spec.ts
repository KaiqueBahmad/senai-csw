import { TestBed } from '@angular/core/testing';

import { AlunosServiceService } from './alunos-service.service';

describe('AlunosServiceService', () => {
  let service: AlunosServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AlunosServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
