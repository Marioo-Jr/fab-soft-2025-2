import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Page } from '../model/page';
import { Condominio } from '../model/condominio';

@Injectable({
  providedIn: 'root'
})
export class CondominioService {

  apiURL = 'http://localhost:8080/api/v1/condominios'

  constructor(private http:HttpClient){}

  getCondominios(){
    return this.http.get<Page>(this.apiURL)
  }

  saveCondominio(condominio:Condominio){
    if (condominio.id){ 
      return this.http.put(this.apiURL + '/' + condominio.id, condominio)

    }
    return this.http.post(this.apiURL, condominio)
  }

  getCondominioById(id:String){
    return this.http.get<Condominio>(this.apiURL + '/' + id)
  }

  excluirCondominio(id:string){
    return this.http.delete<Condominio>(this.apiURL + '/' + id)
  }

  

}
