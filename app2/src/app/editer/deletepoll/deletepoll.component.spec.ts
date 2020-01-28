import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletepollComponent } from './deletepoll.component';

describe('DeletepollComponent', () => {
  let component: DeletepollComponent;
  let fixture: ComponentFixture<DeletepollComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeletepollComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletepollComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
