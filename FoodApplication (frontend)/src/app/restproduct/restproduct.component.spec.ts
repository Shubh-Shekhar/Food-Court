import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestproductComponent } from './restproduct.component';

describe('RestproductComponent', () => {
  let component: RestproductComponent;
  let fixture: ComponentFixture<RestproductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestproductComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RestproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
