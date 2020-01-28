import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddnewsbywriterComponent } from './addnewsbywriter.component';

describe('AddnewsbywriterComponent', () => {
  let component: AddnewsbywriterComponent;
  let fixture: ComponentFixture<AddnewsbywriterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddnewsbywriterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddnewsbywriterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
