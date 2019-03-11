import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  apiUrl = "http://localhost:8080/categoria"

  constructor(private httpClient: HttpClient) { }

  listar(){
    return this.httpClient.get(this.apiUrl);
  }

  adicionar(categoria: any){
    return this.httpClient.post(this.apiUrl, categoria);
  }

}
