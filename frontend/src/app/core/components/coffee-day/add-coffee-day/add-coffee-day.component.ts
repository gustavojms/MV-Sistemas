import { MatInputModule } from '@angular/material/input';
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatDialogModule } from '@angular/material/dialog';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CoffeeDayService } from '../../../../services/coffee-day.service';
import { ToastrService } from 'ngx-toastr';
import { MAT_DATE_LOCALE, MatNativeDateModule } from '@angular/material/core';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-add-coffee-day',
  standalone: true,
  imports: [
    CommonModule,
    MatDialogModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    ReactiveFormsModule,
  ],
  templateUrl: './add-coffee-day.component.html',
  styleUrl: './add-coffee-day.component.css',
  providers: [{ provide: MAT_DATE_LOCALE, useValue: 'pt-BR' }],
})
export class AddCoffeeDayComponent {
  coffeeDate: Date;
  constructor(private api: CoffeeDayService, private toastr: ToastrService) {
    this.coffeeDate = new Date();
  }

  formCoffeeDay = new FormGroup({
    coffeeDate: new FormControl<Date | null>(null),
  });

  onSubmit() {
    return this.api
      .postNewCoffeeDay(this.coffeeDate)
      .subscribe((response: any) => {
        if (response.status === 201) {
          this.toastr.success('Dia do Café cadastrado com sucesso!');
        } else {
          this.toastr.error('Erro ao cadastrar dia do café!');
        }
      });
  }
}
