import { Component } from '@angular/core';
import { Espaco } from '../model/espaco';
import { HttpClientModule } from '@angular/common/http';
import { EspacoService } from '../service/espaco.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router,ActivatedRoute,ParamMap } from '@angular/router';

@Component({
  selector: 'app-form-espaco',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-espaco.html',
  styleUrl: './form-espaco.css',
  providers: [EspacoService, Router]

})
export class FormEspaco {

  espaco: Espaco = new Espaco()

  constructor(
    private espacoService:EspacoService,
    private router:Router,
    private activeRouter: ActivatedRoute
  ){
    let id = this.activeRouter.snapshot.paramMap.get('id')
    if(id){
      this.espacoService .getEspacoById(id).subscribe(res =>{
        this.espaco = res
      })
    }
  }

  salvar(){
  
    this.espacoService.saveEspaco(this.espaco).subscribe(resultado => {
        this.router.navigate(['espacos'])
      })
  }



}
