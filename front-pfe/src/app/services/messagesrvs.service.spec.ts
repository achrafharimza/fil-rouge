import { TestBed } from '@angular/core/testing';

import { MessagesrvsService } from './messagesrvs.service';

describe('MessagesrvsService', () => {
  let service: MessagesrvsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MessagesrvsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
