import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCoffeeDayComponent } from './add-coffee-day.component';

describe('AddCoffeeDayComponent', () => {
  let component: AddCoffeeDayComponent;
  let fixture: ComponentFixture<AddCoffeeDayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddCoffeeDayComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddCoffeeDayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
