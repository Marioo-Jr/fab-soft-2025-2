import { Component } from '@angular/core';
import { Pessoa } from '../model/pessoa';
import { PessoaService } from '../service/pessoa.service';
import { HttpClientModule } from '@angular/common/http'; 
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-pessoa',
  imports: [HttpClientModule,CommonModule,FormsModule],
  templateUrl: './form-pessoa.html',
  styleUrl: './form-pessoa.css',
  providers: [PessoaService, Router]

})
export class FormPessoa {

  pessoa:Pessoa = new Pessoa();

  constructor(
    private pessoaService: PessoaService,
    private router:Router
  ){}

  salvar(){
    this.pessoaService.savePessoa(this.pessoa).subscribe(resultado => {
          this.router.navigate(['pessoas'])
      })
  }

}
