import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchbydateComponent } from './searchbydate.component';

describe('SearchbydateComponent', () => {
  let component: SearchbydateComponent;
  let fixture: ComponentFixture<SearchbydateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchbydateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchbydateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
