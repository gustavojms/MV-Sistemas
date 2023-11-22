import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.prod';

@Injectable({
  providedIn: 'root',
})
export class ItemOptionService {
  constructor(private http: HttpClient) {
    this.http = http;
  }

  postNewItemOption(data: any) {
    return this.http.post(
      `${environment.apiUrl}/item-option`,
      {
        item: data.item,
      },
      {
        observe: 'response',
      }
    );
  }

  getItemOptions() {
    return this.http.get(`${environment.apiUrl}/item-option`, {
      observe: 'response',
    });
  }

  editItemOption(itemOptionId: any, data: any) {
    return this.http.put(
      `${environment.apiUrl}/item-option/${itemOptionId}`,
      {
        item: data.item,
      },
      {
        observe: 'response',
      }
    );
  } 

  deleteItemOption(itemOptionId: any) {
    return this.http.delete(`${environment.apiUrl}/item-option/${itemOptionId}`, {
      observe: 'response',
      responseType: 'text',
    });
  }

  getItemOptionByName(itemOptionName: string) {
    return this.http.get(`${environment.apiUrl}/item-option/${itemOptionName}`, {
      observe: 'response',
    });
  }
}
