import { Component, Inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MAT_DIALOG_DATA, MatDialogModule } from '@angular/material/dialog';

@Component({
  selector: 'app-coffee-details',
  standalone: true,
  imports: [CommonModule, MatDialogModule],
  templateUrl: './coffee-details.component.html',
  styleUrl: './coffee-details.component.css'
})
export class CoffeeDetailsComponent {
  constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }

  
}
