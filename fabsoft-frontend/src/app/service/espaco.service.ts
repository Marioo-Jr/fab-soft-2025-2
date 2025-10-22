import { Injectable } from '@angular/core';
import { Espaco } from '../model/espaco';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})

export class EspacoService {

  apiURL = 'http://localhost:8080/api/v1/espacos'
  constructor(private http:HttpClient){}
  
  getEspacos(){
    return this.http.get<Espaco[]>(this.apiURL)
  }
  saveEspaco(espaco:Espaco){

    return this.http.post(this.apiURL, espaco)

  }
}
