import { FormBuilder, FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ItemOptionService } from '../../../../services/item-option.service';
import { MatDialogModule } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-add-item',
  standalone: true,
  imports: [CommonModule, MatDialogModule, MatButtonModule, MatInputModule, MatFormFieldModule, ReactiveFormsModule],
  templateUrl: './add-item.component.html',
  styleUrl: './add-item.component.css'
})
export class AddItemComponent {
  constructor(private fb: FormBuilder, private api: ItemOptionService, private toastr: ToastrService) {}

  formItemOption = this.fb.group({
    item: new FormControl('', Validators.required),
  });

  onSubmit() {
    return this.api.postNewItemOption(this.formItemOption.value).subscribe((response: any) => {
      if (response.status === 201) {
        this.toastr.success('Item cadastrado com sucesso!');
      } else {
        this.toastr.error('Erro ao cadastrar item!');
      }
    });
  }
}
