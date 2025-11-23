import { Component } from '@angular/core';
import { Imovel } from '../model/imovel';
import { ImovelService } from '../service/imovel.service';
import { HttpClientModule } from '@angular/common/http'; 
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router,ActivatedRoute,ParamMap} from '@angular/router';
import { Condominio } from '../model/condominio';
import { CondominioService } from '../service/condominio.service';

@Component({
  selector: 'app-form-imovel',
  imports: [HttpClientModule,CommonModule,FormsModule],
  templateUrl: './form-imovel.html',
  styleUrl: './form-imovel.css',
  //providers: [ImovelService, Router]
})
export class FormImovel {

  imovel: Imovel = new Imovel();
  listaCondominio: Condominio [] = [];

  constructor(
    private condominioService: CondominioService,
    private imovelService: ImovelService,
    private router:Router,
    private activateRoute:ActivatedRoute

  ){
    this.condominioService.getCondominios().subscribe(page =>{
      this.listaCondominio = page.content;
    })

    let id = this.activateRoute.snapshot.paramMap.get('id');
    if(id){
      this.imovelService.getImovelById(id)
        .subscribe(res => {
          this.imovel = res
        })
      }
  }

  salvar(){
    this.imovelService.saveImovel(this.imovel)
      .subscribe(resultado =>{
        this.router.navigate(['imoveis'])
      })
  }

  comparaCondominios (obj1: Condominio, objs2: Condominio):boolean{

    return obj1 && objs2 ? obj1.id === objs2.id : obj1 === objs2

  }


}
