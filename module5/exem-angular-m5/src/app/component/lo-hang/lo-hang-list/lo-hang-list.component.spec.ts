import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoHangListComponent } from './lo-hang-list.component';

describe('LoHangListComponent', () => {
  let component: LoHangListComponent;
  let fixture: ComponentFixture<LoHangListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoHangListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoHangListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
