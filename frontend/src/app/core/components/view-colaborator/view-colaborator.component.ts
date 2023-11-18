import { AfterViewInit, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ColaboratorService } from '../../../services/colaborator.service';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { EditColaboratorComponent } from '../edit-colaborator/edit-colaborator.component';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-view-colaborator',
  standalone: true,
  imports: [CommonModule, MatTableModule, MatIconModule, MatDialogModule],
  templateUrl: './view-colaborator.component.html',
  styleUrl: './view-colaborator.component.css',
})
export class ViewColaboratorComponent implements AfterViewInit {
  displayedColumns: string[] = ['name', 'cpf', 'actions'];
  dataSource: any;

  constructor(private api: ColaboratorService, public dialog: MatDialog, private toastr: ToastrService) {}

  ngAfterViewInit(): any {
    return this.api.getColaborators().subscribe((response: any) => {
      this.dataSource = response.body;
    });
  }

  openEditColaborator(data: any): any {
    const dialogRef = this.dialog.open(EditColaboratorComponent, {
      data: {
        name: data.name,
        cpf: data.cpf,
        userId: data.id,
      },
    });

    dialogRef.afterClosed().subscribe(() => {
      this.ngAfterViewInit();
    });
  }

  deleteColaborator(id: any): any {
    return this.api.deleteColaborator(id).subscribe((response: any) => {
      console.log(response);
      if (response.status === 200) {
        this.toastr.success('Colaborador deletado com sucesso!');
      } else {
        this.toastr.error('Erro ao deletar colaborador!');
      }
    });
  }
}
