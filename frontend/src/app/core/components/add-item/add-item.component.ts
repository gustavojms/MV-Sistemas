import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ItemOptionService } from '../../../services/item-option.service';
import { MatDialogModule } from '@angular/material/dialog';

@Component({
  selector: 'app-add-item',
  standalone: true,
  imports: [CommonModule, MatDialogModule],
  templateUrl: './add-item.component.html',
  styleUrl: './add-item.component.css'
})
export class AddItemComponent {
  constructor(private api: ItemOptionService) {}

  onSubmit(data: any) {
    return this.api.postNewItemOption(data).subscribe((response: any) => {
      if (response.status === 201) {
        console.log('Item cadastrado com sucesso!');
      } else {
        console.log('Erro ao cadastrar item!');
      }
    });
  }
}
