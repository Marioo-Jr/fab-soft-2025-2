import { Imovel } from '../model/imovel';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Page } from '../model/page';

@Injectable({
  providedIn: 'root'
})
export class ImovelService {

  apiURL = 'http://localhost:8080/api/v1/imoveis'

  
  constructor(private http:HttpClient){}

  getImoveis(){

    return this.http.get<Page>(this.apiURL)

  }

  saveImovel(imovel:Imovel){
      if (imovel.id){ 
        return this.http.put(this.apiURL + '/' + imovel.id, imovel)
  
      }
      return this.http.post(this.apiURL, imovel)
    }

  getImovelById(id:string){
    return this.http.get<Imovel>(this.apiURL+'/'+id)

  }

  excluirPessoa(id:string){
    return this.http.delete<Imovel>(this.apiURL + '/' + id)
  }


}
