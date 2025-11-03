import { Component } from '@angular/core';
import { Pessoa } from '../model/pessoa';
import { PessoaService } from '../service/pessoa.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pessoa.component',
  imports: [
    HttpClientModule,CommonModule],
  templateUrl: './pessoa.component.html',
  styleUrl: './pessoa.component.css',
  providers: [PessoaService, Router]
})

export class PessoaComponent {

  listaPessoas: Pessoa[] = [];

  constructor(
    private pessoaService: PessoaService,
    private router:Router
  ){}

    ngOnInit(){
      console.log('Carregando pessoas....');

      this.pessoaService.getPessoas().subscribe(page => {
        this.listaPessoas = page.content;
      });
    }

    novo(){
      this.router.navigate(['pessoas/novo'])

    }

  }
  
