import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ColaboratorService {
  constructor(private http: HttpClient) {
    this.http = http;
  }

  postNewColaborator(data: any) {
    return this.http.post(
      'http://localhost:8080/user',
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
    return this.http.get('http://localhost:8080/user', {
      observe: 'response',
    });
  }

  editColaborator(userId: any, data: any) {
    return this.http.put(
      `http://localhost:8080/user/${userId}`,
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
    return this.http.delete(`http://localhost:8080/user/${userId}`, {
      observe: 'response',
      responseType: 'text',
    });
  }
}
