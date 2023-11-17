import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ColaboratorService {

  constructor(private http: HttpClient) { 
    this.http = http;
  }

  postNewColaborator(data: any) {
    return this.http.post('http://localhost:8080/user', {
      name: data.name,
      cpf: data.cpf
    }).subscribe((response: any) => {
      console.log(response.status)
    });
  }
}
