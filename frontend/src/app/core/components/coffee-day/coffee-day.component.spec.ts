import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeDayComponent } from './coffee-day.component';

describe('CoffeeDayComponent', () => {
  let component: CoffeeDayComponent;
  let fixture: ComponentFixture<CoffeeDayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoffeeDayComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CoffeeDayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
