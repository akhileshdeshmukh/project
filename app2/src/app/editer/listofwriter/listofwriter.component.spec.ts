import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListofwriterComponent } from './listofwriter.component';

describe('ListofwriterComponent', () => {
  let component: ListofwriterComponent;
  let fixture: ComponentFixture<ListofwriterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListofwriterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListofwriterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
