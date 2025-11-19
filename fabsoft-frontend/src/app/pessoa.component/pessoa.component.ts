import { Component,ElementRef, viewChild, ViewChild } from '@angular/core';
import { Pessoa } from '../model/pessoa';
import { PessoaService } from '../service/pessoa.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import * as bootstrap from 'bootstrap'

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
  
  @ViewChild('myModal') modalElement: ElementRef;
  private modal: bootstrap.Modal

  private pessoaSelecionada!: Pessoa

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
    

    alterar(pessoa:Pessoa){
      this.router.navigate(['pessoas/alterar',pessoa.id]);

    }
    
    abrirConfirmacao(pessoa:Pessoa){
      this.pessoaSelecionada = pessoa
      this.modal = new bootstrap.Modal(this.modalElement.nativeElement)
      this.modal.show()


    }

    fecharConfirmacao(){
      this.modal.hide()
    }

    confirmarExclusao(){
      this.pessoaService.excluirPessoa(this.pessoaSelecionada.id.toString())
        .subscribe(
          () => {
            this.fecharConfirmacao()
            this.pessoaService.getPessoas()
            .subscribe (
                page => {
                  this.listaPessoas = page.content
                }
            )
          }, 
          error =>{
            console.log('Error ao exlcuir cliente', error)
          }
      )
    }

  }
  
