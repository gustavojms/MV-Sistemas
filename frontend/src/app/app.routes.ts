import { Routes } from '@angular/router';
import { ViewColaboratorComponent } from './core/components/view-colaborator/view-colaborator.component';
import { CoffeeDayComponent } from './core/components/coffee-day/coffee-day.component';
import { AddItemComponent } from './core/components/add-item/add-item.component';
import { CoffeeDetailsComponent } from './core/components/coffee-day/coffee-details/coffee-details.component';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: ViewColaboratorComponent },
  { path: 'coffeeday', component: CoffeeDayComponent },
  { path: 'coffeeday/:id', component: CoffeeDetailsComponent },
  { path: 'item', component: AddItemComponent }
];
