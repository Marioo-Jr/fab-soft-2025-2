import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; 
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Locacao } from '../model/locacao';
import { LocacaoService } from '../service/locacao.service';


@Component({
  selector: 'app-form-locacao',
  imports: [HttpClientModule,CommonModule,FormsModule],
  templateUrl: './form-locacao.html',
  styleUrl: './form-locacao.css'
})
export class FormLocacao {

locacao:Locacao = new Locacao

constructor(
    private locacaoService: LocacaoService,
    private router:Router
  ){}

  salvar(){
    this.locacaoService.saveLocacao(this.locacao)
      .subscribe(resultado => {
          this.router.navigate(['pessoas'])
    })
  }
  


}
