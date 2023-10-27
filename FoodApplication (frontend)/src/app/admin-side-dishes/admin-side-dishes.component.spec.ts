import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminSideDishesComponent } from './admin-side-dishes.component';

describe('AdminSideDishesComponent', () => {
  let component: AdminSideDishesComponent;
  let fixture: ComponentFixture<AdminSideDishesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminSideDishesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminSideDishesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
