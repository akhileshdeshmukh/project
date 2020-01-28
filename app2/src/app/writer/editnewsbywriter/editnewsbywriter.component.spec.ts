import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditnewsbywriterComponent } from './editnewsbywriter.component';

describe('EditnewsbywriterComponent', () => {
  let component: EditnewsbywriterComponent;
  let fixture: ComponentFixture<EditnewsbywriterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditnewsbywriterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditnewsbywriterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
