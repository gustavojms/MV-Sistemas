import { Component, Inject, AfterViewInit, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { CoffeeDayService } from '../../../../services/coffee-day.service';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-coffee-details',
  standalone: true,
  imports: [CommonModule, MatFormFieldModule, MatSelectModule, MatInputModule, ReactiveFormsModule, FormsModule],
  templateUrl: './coffee-details.component.html',
  styleUrl: './coffee-details.component.css'
})
export class CoffeeDetailsComponent implements OnInit {
  constructor(private route: ActivatedRoute, private api: CoffeeDayService) { }

  data: {
    id: number,
    coffeeDate: string
  } | undefined;

  colaborators: any;
  items: any;
  selectedValue: number | undefined;

  formAssignment = new FormGroup({
    colaboratorId: new FormControl(''),
    itemOptionId: new FormControl(''),
  })

  ngOnInit(): any {
    const id =  Number(this.route.snapshot.paramMap.get('id'));

    const colaboratorId = this.api.getAllColaborators().subscribe((response: any) => {
      this.colaborators = response.body;
    });

    const items = this.api.getAllItems().subscribe((response: any) => {
      this.items = response.body;
    });
    
    const coffeeDetails = this.api.getCoffeeDayById(id).subscribe((response: any) => {
      this.data = response.body;
    });

    return [colaboratorId, items, coffeeDetails];
  }

  onSubmit() {
    return this.api.assignColaboratorToCoffeeDay({
      userId: this.formAssignment.value.colaboratorId,
      itemId: this.formAssignment.value.itemOptionId,
      coffeeDayId: this.data?.id,
    }).subscribe((response: any) => {
      console.log(response)
      if (response.status === 201) {
        console.log(response);
      } else {
        console.log(response);
      }
    });
  }
  
}
