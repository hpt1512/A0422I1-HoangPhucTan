import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GeneralsCreateComponent } from './generals-create.component';

describe('GeneralsCreateComponent', () => {
  let component: GeneralsCreateComponent;
  let fixture: ComponentFixture<GeneralsCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GeneralsCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GeneralsCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
