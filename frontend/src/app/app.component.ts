import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { HeaderComponent } from './core/components/header/header.component';
import { AddColaboratorComponent } from './core/components/colaborator/add-colaborator/add-colaborator.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ViewColaboratorComponent } from './core/components/colaborator/view-colaborator/view-colaborator.component';
import { AddItemComponent } from './core/components/item-option/add-item/add-item.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    HeaderComponent,
    RouterOutlet,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'frontend';
}
