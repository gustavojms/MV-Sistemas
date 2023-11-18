import { Component, Inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MAT_DIALOG_DATA, MatDialog, MatDialogModule } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { ColaboratorService } from '../../../services/colaborator.service';

@Component({
  selector: 'app-confirm-delete',
  standalone: true,
  imports: [CommonModule, MatDialogModule],
  templateUrl: './confirm-delete.component.html',
  styleUrl: './confirm-delete.component.css'
})
export class ConfirmDeleteComponent {
  constructor(private api: ColaboratorService, public dialog: MatDialog, private toastr: ToastrService, @Inject(MAT_DIALOG_DATA) public data: {
    name: string,
    cpf: string,
    userId: number,
  }) { }

  deleteColaborator(id: any): any {
    return this.api.deleteColaborator(id).subscribe((response: any) => {
      if (response.status === 200) {
        this.toastr.success('Colaborador deletado com sucesso!');
      } else {
        this.toastr.error('Erro ao deletar colaborador!');
      }
    });
  }
}
