import { AfterViewInit, Component, OnChanges, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ColaboratorService } from '../../../../services/colaborator.service';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { EditColaboratorComponent } from '../edit-colaborator/edit-colaborator.component';
import { ToastrService } from 'ngx-toastr';
import {MatCardModule} from '@angular/material/card';
import { ConfirmDeleteComponent } from '../../confirm-delete/confirm-delete.component';
import { AddColaboratorComponent } from '../add-colaborator/add-colaborator.component';

@Component({
  selector: 'app-view-colaborator',
  standalone: true,
  imports: [CommonModule, MatTableModule, MatIconModule, MatDialogModule, MatCardModule],
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

  openNewColaborator() {
    const dialogRef = this.dialog.open(AddColaboratorComponent);

    dialogRef.afterClosed().subscribe(() => {
      this.ngAfterViewInit();
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

  confirmDelete(data: any) {
    const dialog = this.dialog.open(ConfirmDeleteComponent, {
      data: {
        name: data.name,
        cpf: data.cpf,
        userId: data.id,
      }
    });

    dialog.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result)
      }
    });
  }
}
