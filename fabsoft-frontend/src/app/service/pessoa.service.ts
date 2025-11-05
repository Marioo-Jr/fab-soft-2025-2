import { Injectable } from '@angular/core';
import { Pessoa } from '../model/pessoa';
import { HttpClient } from '@angular/common/http';
import { Page } from '../model/page';


@Injectable({
  providedIn: 'root'
})
export class PessoaService {
  apiURL = 'http://localhost:8080/api/v1/pessoas'


  constructor(private http: HttpClient){}

  getPessoas(){
    return this.http.get<Page>(this.apiURL)
  }
  
  savePessoa(pessoa:Pessoa){
    if (pessoa.id){
      return this.http.put(this.apiURL + '/' + pessoa.id, pessoa)

    }
    return this.http.post(this.apiURL, pessoa)
  }

  getPessoaById(id:string){
    return this.http.get<Pessoa>(this.apiURL+'/'+id)

  }
  excluirPessoa(id:string){
    return this.http.delete<Pessoa>(this.apiURL+'/'+id)
  }

}
