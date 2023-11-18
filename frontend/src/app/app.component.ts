import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './core/components/header/header.component';
import { AddColaboratorComponent } from './core/components/add-colaborator/add-colaborator.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ViewColaboratorComponent } from './core/components/view-colaborator/view-colaborator.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, HeaderComponent, AddColaboratorComponent, ReactiveFormsModule, ViewColaboratorComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
