import { Component, Inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MAT_DIALOG_DATA, MatDialog, MatDialogModule } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { ItemOptionService } from '../../../../services/item-option.service';

@Component({
  selector: 'app-confirm-delete',
  standalone: true,
  imports: [CommonModule, MatDialogModule],
  templateUrl: './confirm-delete.component.html',
  styleUrl: './confirm-delete.component.css'
})
export class ConfirmDeleteComponent {
  constructor(private api: ItemOptionService, public dialog: MatDialog, private toastr: ToastrService, @Inject(MAT_DIALOG_DATA) public data: {
    itemOptionId: number,
    item: string,
  }) { }

  deleteItem(id: any): any {
    return this.api.deleteItemOption(id).subscribe((response: any) => {
      if (response.status === 200) {
        this.toastr.success('Item deletado com sucesso!');
      } else {
        this.toastr.error('Erro ao deletar item!');
      }
    });
  }
}
