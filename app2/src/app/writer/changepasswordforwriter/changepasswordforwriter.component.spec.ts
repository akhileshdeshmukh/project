import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangepasswordforwriterComponent } from './changepasswordforwriter.component';

describe('ChangepasswordforwriterComponent', () => {
  let component: ChangepasswordforwriterComponent;
  let fixture: ComponentFixture<ChangepasswordforwriterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChangepasswordforwriterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangepasswordforwriterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
