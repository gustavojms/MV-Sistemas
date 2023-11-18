import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ItemOptionService {
  constructor(private http: HttpClient) {
    this.http = http;
  }

  postNewItemOption(data: any) {
    return this.http.post(
      'http://localhost:8080/item-ption',
      {
        item: data.item,
      },
      {
        observe: 'response',
      }
    );
  }

  getItemOptions() {
    return this.http.get('http://localhost:8080/item-option', {
      observe: 'response',
    });
  }

  editItemOption(itemOptionId: any, data: any) {
    return this.http.put(
      `http://localhost:8080/item-option/${itemOptionId}`,
      {
        item: data.item,
      },
      {
        observe: 'response',
      }
    );
  } 

  deleteItemOption(itemOptionId: any) {
    return this.http.delete(`http://localhost:8080/item-option/${itemOptionId}`, {
      observe: 'response',
      responseType: 'text',
    });
  }

  getItemOptionByName(itemOptionName: string) {
    return this.http.get(`http://localhost:8080/item-option/${itemOptionName}`, {
      observe: 'response',
    });
  }
}
