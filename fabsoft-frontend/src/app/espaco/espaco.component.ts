import { Component,ElementRef,ViewChild,viewChild } from '@angular/core';
import { Espaco } from '../model/espaco';
import { EspacoService } from '../service/espaco.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import * as bootstrap from 'bootstrap'; 

@Component({
  selector: 'app-espaco',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './espaco.html',
  styleUrl: './espaco.css',
  providers:[EspacoService,Router]
})
export class EspacoComponent {

  listaEspacos: Espaco[] = []

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal

  private espacoSelecionado!: Espaco

  constructor(private espacoService: EspacoService,
    private router:Router){}
    ngOnInit(){
      console.log('carregando espacos')
      this.espacoService.getEspacos().subscribe(espacos =>{
        this.listaEspacos = espacos
      })

    }

    novo (){
      this.router.navigate(['espacos/novo'])
    }
    alterar(espaco: Espaco){
      this.router.navigate(['espacos/alterar',espaco.id])

    }

    abrirConfirmacao(espaco:Espaco){
      this.espacoSelecionado = espaco
      this.modal = new bootstrap.Modal(this.modalElement.nativeElement)
      this.modal.show()
    }

    fecharConfirmacao(){
      this.modal.hide()
    }

    confirmarExclusao(){
      this.espacoService.excluirEspaco(this.espacoSelecionado.id.toString())
        .subscribe(
          () => {
            this.fecharConfirmacao()
            this.espacoService.getEspacos()
              .subscribe(
                espacos => {
                  this.listaEspacos = espacos
                }
              )
          },
          error => {
            console.error("Error ao excluir espaco", error)
          }
        )
    }

  }

