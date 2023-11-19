import { Component, Inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogModule } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { ItemOptionService } from '../../../../services/item-option.service';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-edit-item',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, MatButtonModule, MatInputModule, MatFormFieldModule, MatDialogModule],
  templateUrl: './edit-item.component.html',
  styleUrl: './edit-item.component.css'
})
export class EditItemComponent {

  constructor(private fb: FormBuilder, private api: ItemOptionService, private toastr: ToastrService, @Inject(MAT_DIALOG_DATA) public data: {
    itemOptionId: number,
    item: string,
  }) {}

  editFormItemOption = this.fb.group({
    item: new FormControl(this.data.item, Validators.required),
  });

  onSubmit() {
    return this.api.editItemOption(this.data.itemOptionId, {
      item: this.editFormItemOption.value.item,
    }).subscribe((response: any) => {
      if (response.status === 200) {
        this.toastr.success('Item editado com sucesso!');
      } else {
        this.toastr.error('Erro ao editar item!');
      }
    });
  }
}
