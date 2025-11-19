import { Imovel } from '../model/imovel';
import { ImovelService } from '../service/imovel.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Page } from '../model/page';
import { Router } from '@angular/router';
import { Component,ElementRef, ViewChild } from '@angular/core';
import * as bootstrap from 'bootstrap'


@Component({
  selector: 'app-imovel.component',
  imports: [HttpClientModule,CommonModule],
  templateUrl: './imovel.component.html',
  styleUrl: './imovel.component.css',
  //providers: [ImovelService,Router]
})
export class ImovelComponent {

  listaImoveis: Imovel[] = [];
  @ViewChild('myModal') modalElement: ElementRef;
  private modal: bootstrap.Modal
  private imovelSelecionado!: Imovel

  constructor(
    private imovelService:ImovelService,
    private router:Router
  ){

  }
  
  ngOnInit(){
    console.log('Carregando imoveis....');
    this.imovelService.getImoveis().subscribe (page =>{
      this.listaImoveis = page.content
    })
  }

  novo(){
    this.router.navigate(['imoveis/novo'])
  }

  alterar(imovel:Imovel){
    this.router.navigate(['imoveis/alterar',imovel.id])
  }

  abrirConfirmacao(imovel:Imovel){
    this.imovelSelecionado = imovel
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement)
    this.modal.show()

  }
    
  fecharConfirmacao(){
    this.modal.hide()
  }

  confirmarExclusao(){
      this.imovelService.excluirPessoa(this.imovelSelecionado.id.toString())
        .subscribe(
          () => {
            this.fecharConfirmacao()
            this.imovelService.getImoveis()
            .subscribe (
                page => {
                  this.listaImoveis = page.content
                }
            )
          }, 
          error =>{
            console.log('Error ao exlcuir cliente', error)
          }
      )
    }

}
