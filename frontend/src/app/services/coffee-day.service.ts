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

  postNewCoffeeDay(data: any) {
    return this.http.post(
      'http://localhost:8080/coffee-day',
      {
        day: data.day,
        name: data.name,
        cpf: data.cpf,
        brought: data.brought,
      },
      {
        observe: 'response',
      }
    );
  }

}
