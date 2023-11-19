import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class CoffeeDayService {
  constructor(private http: HttpClient) {
    this.http = http;
  }

  getCoffeeDays() {
    return this.http.get('http://localhost:8080/coffee-day', {
      observe: 'response',
    });
  }

  getCoffeeDayById(id: number) {
    return this.http.get(`http://localhost:8080/coffee-day/${id}`, {
      observe: 'response',
    });
  }

  postNewCoffeeDay(data: any) {
    console.log(data);
    return this.http.post(
      'http://localhost:8080/coffee-day',
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
      'http://localhost:8080/item-assignment',
      {
        userId: data.userId,
        coffeeDayId: data.coffeeDayId,
        itemId: data.itemId,
      },
      { observe: 'response' }
    );
  }

  getAllColaborators() {
    return this.http.get('http://localhost:8080/user', {
      observe: 'response',
    });
  }

  getAllItems() {
    return this.http.get('http://localhost:8080/item-option', {
      observe: 'response',
    });
  }
}
