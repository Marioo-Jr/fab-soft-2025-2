import { Component } from '@angular/core';
import { Espaco } from '../model/espaco';
import { HttpClientModule } from '@angular/common/http';
import { EspacoService } from '../service/espaco.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router,ActivatedRoute,ParamMap } from '@angular/router';
import { Condominio } from '../model/condominio';
import { CondominioService } from '../service/condominio.service';

@Component({
  selector: 'app-form-espaco',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-espaco.html',
  styleUrl: './form-espaco.css',
  //providers: [EspacoService, Router]

})
export class FormEspaco {

  espaco: Espaco = new Espaco()

  listaCondominio: Condominio [] = [];

  constructor(
    private espacoService:EspacoService,
    private condominioService: CondominioService,
    private router:Router,
    private activeRouter: ActivatedRoute
    

  ){
    let id = this.activeRouter.snapshot.paramMap.get('id')
    
    this.condominioService.getCondominios().subscribe(page =>{
      this.listaCondominio = page.content;
    })

    if(id){
      this.espacoService .getEspacoById(id).subscribe(res =>{
        this.espaco = res
        console.log(this.espaco);
      })
    }
  }

  salvar(){
  
    this.espacoService.saveEspaco(this.espaco).subscribe(resultado => {
        this.router.navigate(['espacos'])
      })
  }

  comparaCondominios (obj1: Condominio, objs2: Condominio):boolean{

    return obj1 && objs2 ? obj1.id === objs2.id : obj1 === objs2

  }


}
