import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { ColaboratorService } from '../../../services/colaborator.service';

@Component({
  selector: 'app-add-colaborator',
  standalone: true,
  imports: [CommonModule, MatDialogModule, MatButtonModule, MatInputModule, MatFormFieldModule, ReactiveFormsModule],
  templateUrl: './add-colaborator.component.html',
  styleUrl: './add-colaborator.component.css'
})
export class AddColaboratorComponent {
  constructor(private fb: FormBuilder, private api: ColaboratorService) { }
  
  formColaborator = new FormGroup({
    name: new FormControl('', Validators.required),
    cpf: new FormControl('', Validators.required),
  })

  onSubmit() {
    this.api.postNewColaborator(this.formColaborator.value);
  }
}
