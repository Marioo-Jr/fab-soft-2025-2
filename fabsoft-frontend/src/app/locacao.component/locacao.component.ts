import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Locacao } from '../model/locacao';
import { LocacaoService } from '../service/locacao.service';
import { Router } from '@angular/router';
import { Component,ElementRef, ViewChild } from '@angular/core';
import * as bootstrap from 'bootstrap'


@Component({
  selector: 'app-locacao.component',
  imports: [
    HttpClientModule,CommonModule],
  templateUrl: './locacao.component.html',
  styleUrl: './locacao.component.css',
  providers: [LocacaoService,Router]
})
export class LocacaoComponent {

  listaLocacao: Locacao[] = [];
  @ViewChild('myModal') modalElement: ElementRef;
  private modal: bootstrap.Modal;
  private pessoaSelecionada!: Locacao;

  constructor(
    private locacaoService:LocacaoService,
    private router:Router
    
  ){}

  ngOnInit(){
    console.log('Carregando Locacoes ...');

    this.locacaoService.getLocacoes().subscribe (page => {
      this.listaLocacao = page.content;

    }
    )
  }

  novo(){
    this.router.navigate(['locacoes/novo'])
  }

  alterar(locacao:Locacao){

    this.router.navigate(['locacoes/alterar',locacao.id])

  }

  abrirConfirmacao(locacao:Locacao){
      this.pessoaSelecionada = locacao
      this.modal = new bootstrap.Modal(this.modalElement.nativeElement)
      this.modal.show()

    }

    fecharConfirmacao(){
      this.modal.hide()
    }

    confirmarExclusao(){
      this.locacaoService.excluirLocacao(this.pessoaSelecionada.id.toString())
        .subscribe(
          () => {
            this.fecharConfirmacao()
            this.locacaoService.getLocacoes()
            .subscribe (
                page => {
                  this.listaLocacao = page.content
                }
            )
          }, 
          error =>{
            console.log('Error ao exlcuir locacao', error)
          }
      )
    }

}
