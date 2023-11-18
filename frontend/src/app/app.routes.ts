import { Routes } from '@angular/router';
import { ViewColaboratorComponent } from './core/components/view-colaborator/view-colaborator.component';
import { CoffeeDayComponent } from './core/components/coffee-day/coffee-day.component';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'home', component: ViewColaboratorComponent, pathMatch: 'full' },
  { path: 'coffeeday', component: CoffeeDayComponent, pathMatch: 'full' }
];
