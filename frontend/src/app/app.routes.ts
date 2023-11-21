import { Routes } from '@angular/router';
import { ViewColaboratorComponent } from './core/components/colaborator/view-colaborator/view-colaborator.component';
import { CoffeeDayComponent } from './core/components/coffee-day/coffee-day.component';
import { CoffeeDetailsComponent } from './core/components/coffee-day/coffee-details/coffee-details.component';
import { ViewItemComponent } from './core/components/item-option/view-item/view-item.component';
import { HomeComponent } from './core/components/home/home.component';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'colaboradores', component: ViewColaboratorComponent },
  { path: 'coffeeday', component: CoffeeDayComponent },
  { path: 'coffeeday/:id', component: CoffeeDetailsComponent },
  { path: 'itens', component: ViewItemComponent }
];
