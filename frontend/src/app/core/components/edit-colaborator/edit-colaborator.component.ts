import { Component, Inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ColaboratorService } from '../../../services/colaborator.service';
import { ToastrService } from 'ngx-toastr';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MAT_DIALOG_DATA, MatDialogModule } from '@angular/material/dialog';

@Component({
  selector: 'app-edit-colaborator',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, MatButtonModule, MatInputModule, MatFormFieldModule, MatDialogModule],
  templateUrl: './edit-colaborator.component.html',
  styleUrl: './edit-colaborator.component.css'
})
export class EditColaboratorComponent {
  constructor(private fb: FormBuilder, private api: ColaboratorService, private toastr: ToastrService, @Inject(MAT_DIALOG_DATA) public data: {
    name: string,
    cpf: string,
    userId: number,
  }) { }
  
  editFormColaborator = new FormGroup({
    name: new FormControl(this.data.name, Validators.required),
    cpf: new FormControl(this.data.cpf, Validators.required),
  })

  onSubmit() {
    return this.api.editColaborator(this.data.userId, {
      name: this.editFormColaborator.value.name,
      cpf: this.editFormColaborator.value.cpf,
    }).subscribe((response: any) => {
      console.log(response);
      if (response.status === 200) {
        this.toastr.success('Colaborador editado com sucesso!');
      } else {
        this.toastr.error('Erro ao editar colaborador!');
      }
    });
  }
}
