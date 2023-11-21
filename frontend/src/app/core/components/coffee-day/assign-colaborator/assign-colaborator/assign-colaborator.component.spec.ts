import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignColaboratorComponent } from './assign-colaborator.component';

describe('AssignColaboratorComponent', () => {
  let component: AssignColaboratorComponent;
  let fixture: ComponentFixture<AssignColaboratorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AssignColaboratorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AssignColaboratorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
