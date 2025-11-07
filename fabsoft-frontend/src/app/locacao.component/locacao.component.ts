import { Component } from '@angular/core';
import { PessoaService } from '../service/pessoa.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Locacao } from '../model/locacao';
import { LocacaoService } from '../service/locacao.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-locacao.component',
  imports: [
    HttpClientModule,CommonModule],
  templateUrl: './locacao.component.html',
  styleUrl: './locacao.component.css',
  providers: [LocacaoService,Router]
})
export class LocacaoComponent {

  locacao:Locacao = new Locacao()
  listaLocacao: Locacao[] = [];
  

  constructor(
    private locacaoService:LocacaoService,
    private router:Router
  ){}

  ngOninit(){
    console.log('Carregando Locacoes ...');

    this.locacaoService.getLocacoes().subscribe (page => {
      this.listaLocacao = page.content;

    }
    )
  }

  novo(){
    this.router.navigate(['locacoes/novo'])
  }

}
