import { MatInputModule } from '@angular/material/input';
import { Component, Inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatDialogModule } from '@angular/material/dialog';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import {
  MatDatepickerControl,
  MatDatepickerModule,
  MatDatepickerPanel,
} from '@angular/material/datepicker';
import { CoffeeDayService } from '../../../../services/coffee-day.service';
import { ToastrService } from 'ngx-toastr';
import { MAT_DATE_LOCALE, MatNativeDateModule } from '@angular/material/core';
import { MatIconModule } from '@angular/material/icon';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@Component({
  selector: 'app-add-coffee-day',
  standalone: true,
  imports: [
    CommonModule,
    MatDialogModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatIconModule,
    ReactiveFormsModule,
  ],
  templateUrl: './add-coffee-day.component.html',
  styleUrl: './add-coffee-day.component.css',
  providers: [{ provide: MAT_DATE_LOCALE, useValue: 'pt-BR' }],
})
export class AddCoffeeDayComponent {
  coffeeDate: Date;
  constructor(
    @Inject(MAT_DATE_LOCALE) private dateLocale: string,
    private fb: FormBuilder,
    private api: CoffeeDayService,
    private toastr: ToastrService
  ) {
    this.coffeeDate = new Date();
  }

  formCoffeeDay = new FormGroup({
    coffeeDate: new FormControl<Date | null>(null),
  });

  onSubmit() {
    console.log(this.coffeeDate.toISOString());
    console.log(this.coffeeDate);
    return this.api
      .postNewCoffeeDay(this.coffeeDate.toISOString())
      .subscribe((response: any) => {
        if (response.status === 201) {
          this.toastr.success('Dia do Café cadastrado com sucesso!');
        } else {
          this.toastr.error('Erro ao cadastrar café!');
        }
      });
  }
}
