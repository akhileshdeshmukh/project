import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditwriterComponent } from './editwriter.component';

describe('EditwriterComponent', () => {
  let component: EditwriterComponent;
  let fixture: ComponentFixture<EditwriterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditwriterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditwriterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
