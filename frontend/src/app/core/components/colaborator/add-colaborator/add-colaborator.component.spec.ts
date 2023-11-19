import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddColaboratorComponent } from './add-colaborator.component';

describe('AddColaboratorComponent', () => {
  let component: AddColaboratorComponent;
  let fixture: ComponentFixture<AddColaboratorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddColaboratorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddColaboratorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
