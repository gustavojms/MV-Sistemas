import { AfterViewInit, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { ItemOptionService } from '../../../../services/item-option.service';
import { MatDialog } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { AddItemComponent } from '../add-item/add-item.component';
import { EditItemComponent } from '../edit-item/edit-item.component';
import { ConfirmDeleteComponent } from '../confirm-delete/confirm-delete.component';

@Component({
  selector: 'app-view-item',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatTableModule, MatIconModule],
  templateUrl: './view-item.component.html',
  styleUrl: './view-item.component.css'
})
export class ViewItemComponent implements AfterViewInit {
  displayedColumns: string[] = ['id', 'item', 'actions'];
  dataSource: any;

  constructor(private api: ItemOptionService, public dialog: MatDialog, private toastr: ToastrService) {}

  ngAfterViewInit(): any {
    return this.api.getItemOptions().subscribe((response: any) => {
      this.dataSource = response.body;
    });
  }

  openNewItemOption() {
    const dialogRef = this.dialog.open(AddItemComponent);

    dialogRef.afterClosed().subscribe(() => {
      this.ngAfterViewInit();
    });
  }

  openEditItemOption(data: any): any {
    const dialogRef = this.dialog.open(EditItemComponent, {
      data: {
        itemOptionId: data.itemOptionId,
        item: data.item,
      },
    });

    dialogRef.afterClosed().subscribe(() => {
      this.ngAfterViewInit();
    });
  }

  confirmDelete(data: any) {
    console.log(data)
    const dialog = this.dialog.open(ConfirmDeleteComponent, {
      data: {
        item: data.item,
        itemOptionId: data.id,
      }
    });

    dialog.afterClosed().subscribe((result: any) => {
      if (result) {
        this.api.deleteItemOption(data.id).subscribe(() => {
          this.toastr.success('O item foi deletado com sucesso!');
          this.ngAfterViewInit();
        });
      }
    });
  }

}
