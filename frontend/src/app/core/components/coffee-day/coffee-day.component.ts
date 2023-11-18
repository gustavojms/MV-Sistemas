import { AfterViewInit, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { CoffeeDayService } from '../../../services/coffee-day.service';
import { AddCoffeeDayComponent } from './add-coffee-day/add-coffee-day.component';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { CoffeeDetailsComponent } from './coffee-details/coffee-details.component';

@Component({
  selector: 'app-coffee-day',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatTableModule, MatIconModule],
  templateUrl: './coffee-day.component.html',
  styleUrl: './coffee-day.component.css'
})
export class CoffeeDayComponent implements AfterViewInit {
  displayedColumns: string[] = ['date', 'actions'];
  coffeeDatasource: any;

  constructor(private api: CoffeeDayService, public dialog: MatDialog) { }

  ngAfterViewInit(): any {
    return this.api.getCoffeeDays().subscribe((response: any) => {
      this.coffeeDatasource = response.body;
    });
  }

  openNewCoffeeDay() {
    const dialogRef = this.dialog.open(AddCoffeeDayComponent);

    dialogRef.afterClosed().subscribe(() => {
      this.ngAfterViewInit();
    });
  }

  openCoffeeDetails(data: any) {
    const dialogRef = this.dialog.open(CoffeeDetailsComponent, {
      data: {
        coffeeId: data.id,
        coffeeDay: data.coffeeDate,
      },
    });

    dialogRef.afterClosed().subscribe(() => {
      this.ngAfterViewInit();
    });
  }
}
