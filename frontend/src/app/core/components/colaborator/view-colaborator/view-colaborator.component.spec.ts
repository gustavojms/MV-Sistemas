import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewColaboratorComponent } from './view-colaborator.component';

describe('ViewColaboratorComponent', () => {
  let component: ViewColaboratorComponent;
  let fixture: ComponentFixture<ViewColaboratorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewColaboratorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewColaboratorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
