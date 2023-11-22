import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.prod';

@Injectable({
  providedIn: 'root',
})
export class CoffeeDayService {
  constructor(private http: HttpClient) {
    this.http = http;
  }

  getCoffeeDays() {
    return this.http.get(`${environment.apiUrl}/coffee-day`, {
      observe: 'response',
    });
  }

  getCoffeeDayById(id: number) {
    return this.http.get(`${environment.apiUrl}/coffee-day/${id}`, {
      observe: 'response',
    });
  }

  postNewCoffeeDay(data: any) {
    console.log(data);
    return this.http.post(
      `${environment.apiUrl}/coffee-day`,
      {
        coffeeDate: data,
      },
      {
        observe: 'response',
      }
    );
  }

  assignColaboratorToCoffeeDay(data: any) {
    return this.http.post(
      `${environment.apiUrl}/item-assignment`,
      {
        userId: data.userId,
        coffeeDayId: data.coffeeDayId,
        itemId: data.itemId,
      },
      { observe: 'response' }
    );
  }

  getAllColaborators() {
    return this.http.get(`${environment.apiUrl}/user`, {
      observe: 'response',
    });
  }

  getAllItems() {
    return this.http.get(`${environment.apiUrl}/item-option`, {
      observe: 'response',
    });
  }

  getColaboratorsAndItemsByCoffeeDayId(id: number) {
    return this.http.get(`${environment.apiUrl}/item-assignment/${id}`, {
      observe: 'response',
    });
  }

  getCoffeeDetailsByCoffeeDayId(coffeeDayId: number) {
    return this.http.get(
      `${environment.apiUrl}/item-assignment/items/${coffeeDayId}`,
      { observe: 'response' }
    );
  }

  updateBroughtStatus(data: any) {
    return this.http.put(
      `${environment.apiUrl}/item-assignment`,
      {
        userId: data.userId,
        coffeeDayId: data.coffeeDayId,
        hasBroughtItem: data.hasBroughtItem,
      },
      { observe: 'response' }
    );
  }
}
