import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantdishesComponent } from './restaurantdishes.component';

describe('RestaurantdishesComponent', () => {
  let component: RestaurantdishesComponent;
  let fixture: ComponentFixture<RestaurantdishesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestaurantdishesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RestaurantdishesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
