import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Page } from '../model/page';
import { Locacao } from '../model/locacao';

@Injectable({
  providedIn: 'root'
})
export class LocacaoService {
  apiURL = 'http//localhost:8080/api/v1/locacoes'

  
  constructor(private http:HttpClient){}

  getLocacoes(){
    return this.http.get<Page>(this.apiURL)
  }

  saveLocacao(locacao:Locacao){
    return this.http.post(this.apiURL,locacao)
  }

}
