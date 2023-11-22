import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ColaboratorService {
  constructor(private http: HttpClient) {
    this.http = http;
  }

  postNewColaborator(data: any) {
    return this.http.post(
      `${environment.apiUrl}/user`,
      {
        name: data.name,
        cpf: data.cpf,
      },
      {
        observe: 'response',
      }
    );
  }

  getColaborators() {
    return this.http.get(`${environment.apiUrl}/user`, {
      observe: 'response',
    });
  }

  editColaborator(userId: any, data: any) {
    return this.http.put(
      `${environment.apiUrl}/user/${userId}`,
      {
        name: data.name,
        cpf: data.cpf,
      },
      {
        observe: 'response',
      }
    );
  }

  deleteColaborator(userId: any) {
    return this.http.delete(`${environment.apiUrl}/user/${userId}`, {
      observe: 'response',
      responseType: 'text',
    });
  }
}
