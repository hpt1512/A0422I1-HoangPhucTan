import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GeneralsUpdateComponent } from './generals-update.component';

describe('GeneralsUpdateComponent', () => {
  let component: GeneralsUpdateComponent;
  let fixture: ComponentFixture<GeneralsUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GeneralsUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GeneralsUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
