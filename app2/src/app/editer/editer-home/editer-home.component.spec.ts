import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditerHomeComponent } from './editer-home.component';

describe('EditerHomeComponent', () => {
  let component: EditerHomeComponent;
  let fixture: ComponentFixture<EditerHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditerHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditerHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
