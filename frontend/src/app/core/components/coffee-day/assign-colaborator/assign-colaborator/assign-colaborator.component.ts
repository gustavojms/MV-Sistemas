import { Component, Inject, AfterViewInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
} from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MAT_DIALOG_DATA, MatDialogModule } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { CoffeeDayService } from '../../../../../services/coffee-day.service';
import { MatFormFieldModule } from '@angular/material/form-field';

@Component({
  selector: 'app-assign-colaborator',
  standalone: true,
  imports: [
    CommonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  templateUrl: './assign-colaborator.component.html',
  styleUrl: './assign-colaborator.component.css',
})
export class AssignColaboratorComponent implements AfterViewInit {
  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    private toastr: ToastrService,
    private api: CoffeeDayService
  ) {}

  selectedValue: number | undefined;
  colaborators: any;
  items: any;

  formAssignment = new FormGroup({
    colaboratorId: new FormControl(''),
    itemOptionId: new FormControl(''),
  });

  ngAfterViewInit() {
    this.colaborators = this.data?.colaborators;
    this.items = this.data?.items;
  }

  onSubmit() {
    return this.api
      .assignColaboratorToCoffeeDay({
        userId: this.formAssignment.value.colaboratorId,
        itemId: this.formAssignment.value.itemOptionId,
        coffeeDayId: this.data?.coffeeDayId,
      })
      .subscribe((response: any) => {
        if (response.status === 201) {
          this.toastr.success(
            'O colaborador foi relacionado com sucesso ao Coffee Day!'
          );
        } if (response.status === 500) {
          this.toastr.error(
            'Ocorreu um erro ao relacionar o colaborador ao Coffee Day!'
          );
        }
      });
  }
}
