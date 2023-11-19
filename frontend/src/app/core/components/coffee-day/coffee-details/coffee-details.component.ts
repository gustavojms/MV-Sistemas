import { Component, Inject, AfterViewInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { CoffeeDayService } from '../../../../services/coffee-day.service';

@Component({
  selector: 'app-coffee-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './coffee-details.component.html',
  styleUrl: './coffee-details.component.css'
})
export class CoffeeDetailsComponent implements AfterViewInit {
  constructor(private route: ActivatedRoute, private api: CoffeeDayService) { }

  ngAfterViewInit(): any {
    const id =  Number(this.route.snapshot.paramMap.get('id'));
    
    return this.api.getCoffeeDayById(id).subscribe((response: any) => {
      console.log(response);
    });
  }
  
}
