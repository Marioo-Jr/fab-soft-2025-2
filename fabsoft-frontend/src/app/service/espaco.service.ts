import { Injectable } from '@angular/core';
import { Espaco } from '../model/espaco';
import { HttpClient } from '@angular/common/http';
import { Page } from '../model/page';
@Injectable({
  providedIn: 'root'
})

export class EspacoService {

  apiURL = 'http://localhost:8080/api/v1/espacos'
  constructor(private http:HttpClient){}
  
  getEspacos(){
    return this.http.get<Page>(this.apiURL)
  }
  
  saveEspaco(espaco:Espaco){
      if (espaco.id){
        return this.http.put(this.apiURL + '/' + espaco.id, espaco)
  
      }
      return this.http.post(this.apiURL, espaco)
    }


  getEspacoById(id: string){
    return this.http.get<Espaco>(this.apiURL + '/' + id)
  }

  excluirEspaco(id:string){
    return this.http.delete<Espaco>(this.apiURL + '/' + id)

  }
}
