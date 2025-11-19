import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Condominio } from '../model/condominio';
import { CondominioService } from '../service/condominio.service';
import { Router } from '@angular/router';
import { Component,ElementRef, ViewChild } from '@angular/core';
import * as bootstrap from 'bootstrap'



@Component({
  selector: 'app-condominio.component',
  imports: [
    HttpClientModule,CommonModule
  ],
  templateUrl: './condominio.component.html',
  styleUrl: './condominio.component.css',
  //providers: [CondominioService,Router]

})
export class CondominioComponent {

  listaCondominios: Condominio[] = [];
  @ViewChild('myModal') modalElement: ElementRef;
  private modal: bootstrap.Modal
  private condominioSelecionado!:Condominio

  constructor(
    private condominioService: CondominioService,
    private router:Router,
      
  ){}

  ngOnInit(){
      console.log('Carregando condominios....');

      this.condominioService.getCondominios().subscribe(page => {
        this.listaCondominios = page.content;
        
      });
  }

  novo(){
    this.router.navigate(['condominios/novo'])
  }

  alterar(condominio:Condominio){
    this.router.navigate(['condominios/alterar',condominio.id])
  }

  abrirConfirmacao(condominio:Condominio){
      this.condominioSelecionado = condominio
      this.modal = new bootstrap.Modal(this.modalElement.nativeElement)
      this.modal.show()
    }
  
  fecharConfirmacao(){
      this.modal.hide()
  }
  
  confirmarExclusao(){
      this.condominioService.excluirCondominio(this.condominioSelecionado.id.toString())
        .subscribe(
          () => {
            this.fecharConfirmacao()
            this.condominioService.getCondominios()
            .subscribe (
                page => {
                  this.listaCondominios = page.content
                }
            )
          }, 
          error =>{
            console.log('Error ao exlcuir cliente', error)
          }
      )
    }

}
