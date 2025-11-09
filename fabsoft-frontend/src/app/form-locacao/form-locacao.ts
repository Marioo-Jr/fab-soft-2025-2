import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; 
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Locacao } from '../model/locacao';
import { LocacaoService } from '../service/locacao.service';
import { Router,ActivatedRoute, ParamMap } from '@angular/router';


@Component({
  selector: 'app-form-locacao',
  imports: [HttpClientModule,CommonModule,FormsModule],
  templateUrl: './form-locacao.html',
  styleUrl: './form-locacao.css',
  providers: [LocacaoService, Router]
})
export class FormLocacao {

locacao:Locacao = new Locacao

constructor(
    private locacaoService: LocacaoService,
    private router:Router,
    private activateRoute:ActivatedRoute
  ){

    let id = this.activateRoute.snapshot.paramMap.get('id');
    if(id){
      this.locacaoService.getLocacaoById(id)
        .subscribe(res =>{
          this.locacao = res
        })
    }

  }

  salvar(){
    this.locacaoService.saveLocacao(this.locacao)
      .subscribe(resultado => {
          this.router.navigate(['pessoas'])
    })
  }





}
