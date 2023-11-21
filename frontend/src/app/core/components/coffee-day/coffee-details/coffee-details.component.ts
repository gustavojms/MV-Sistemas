import { Component, Inject, AfterViewInit, OnInit, NgIterable } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { CoffeeDayService } from '../../../../services/coffee-day.service';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormControl, FormGroup, FormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { AssignColaboratorComponent } from '../assign-colaborator/assign-colaborator/assign-colaborator.component';
import { MatTableModule } from '@angular/material/table';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';

@Component({
  selector: 'app-coffee-details',
  standalone: true,
  imports: [
    CommonModule,
    MatIconModule,
    MatCardModule,
    MatDialogModule,
    MatTableModule,
    MatCheckboxModule,
    MatSelectModule,
    MatOptionModule,
    FormsModule,
  ],
  templateUrl: './coffee-details.component.html',
  styleUrl: './coffee-details.component.css',
})
export class CoffeeDetailsComponent implements AfterViewInit {
  constructor(
    private route: ActivatedRoute,
    private api: CoffeeDayService,
    private dialog: MatDialog
  ) {}

  displayedColumns: string[] = ['name', 'cpf', 'item', 'brought'];
  datasource: any;

  data:
    | {
        id: number;
        coffeeDate: string;
      }
    | undefined;

  colaborators: any;
  userId: any;
  items: any;
  coffeeItems: any;
  filteredCoffeeItems: any;
  selectedValue: number | undefined;
  id: number | undefined;

  formAssignment = new FormGroup({
    colaboratorId: new FormControl(''),
    itemOptionId: new FormControl(''),
  });

  ngAfterViewInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.id = id;

    const colaboratorId = this.api
      .getAllColaborators()
      .subscribe((response: any) => {
        this.colaborators = response.body;
      });

    const items = this.api.getAllItems().subscribe((response: any) => {
      this.items = response.body;
    });

    const coffeeDetails = this.api
      .getCoffeeDayById(id)
      .subscribe((response: any) => {
        this.data = response.body;
      });

    const allAssignments = this.api
      .getColaboratorsAndItemsByCoffeeDayId(id)
      .subscribe((response: any) => {
        this.datasource = response.body;
      });

    const coffeeItems = this.api
      .getCoffeeDetailsByCoffeeDayIdAndUserId(id)
      .subscribe((response: any) => {
        this.coffeeItems = response.body;
        this.filteredCoffeeItems = this.filterCoffeeItemsByUserId(this.userId)
      });

    return [colaboratorId, items, coffeeDetails, allAssignments, coffeeItems];
  }

  filterCoffeeItemsByUserId(userId: NgIterable<any> | null | undefined): any[] {
    if (!userId) {
      return this.coffeeItems;
    }
    return this.coffeeItems.filter((item: any) => item.id === userId);
  }

  assignColaborator() {
    const dialogRef = this.dialog.open(AssignColaboratorComponent, {
      data: {
        colaborators: this.colaborators,
        items: this.items,
        coffeeDayId: this.data?.id,
      },
    });
    console.log(this.items)

    dialogRef.afterClosed().subscribe(() => {
      this.ngAfterViewInit();
    });
  }

  checked(data: any) {
    console.log(data)
    this.api.updateBroughtStatus({
      userId: data.userId,
      coffeeDayId: this.id,
      hasBroughtItem: !data.hasBroughtItem,
    }).subscribe((response) => {
      console.log(response)
    })
  }
}
