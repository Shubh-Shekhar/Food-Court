import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchBydishNameComponent } from './search-bydish-name.component';

describe('SearchBydishNameComponent', () => {
  let component: SearchBydishNameComponent;
  let fixture: ComponentFixture<SearchBydishNameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchBydishNameComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchBydishNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
