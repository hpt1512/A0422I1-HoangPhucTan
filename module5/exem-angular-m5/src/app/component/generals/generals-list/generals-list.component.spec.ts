import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GeneralsListComponent } from './generals-list.component';

describe('GeneralsListComponent', () => {
  let component: GeneralsListComponent;
  let fixture: ComponentFixture<GeneralsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GeneralsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GeneralsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
