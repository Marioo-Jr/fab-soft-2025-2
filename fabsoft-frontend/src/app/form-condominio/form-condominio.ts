import { Component } from '@angular/core';
import { Condominio } from '../model/condominio';
import { CondominioService } from '../service/condominio.service';
import { HttpClientModule } from '@angular/common/http'; 
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';




@Component({
  selector: 'app-form-condominio',
  imports: [HttpClientModule,CommonModule,FormsModule],
  templateUrl: './form-condominio.html',
  styleUrl: './form-condominio.css',
  providers: [CondominioService, Router]
})
export class FormCondominio {

  condominio: Condominio = new Condominio();

  constructor(
    private condominioService: CondominioService,
    private router:Router,
    private activateRoute:ActivatedRoute
  ){
    let id = this.activateRoute.snapshot.paramMap.get('id');
    if(id){
      this.condominioService.getCondominioById(id)
        .subscribe(res => {
          this.condominio = res
        })
      }
    }


  salvar(){
    this.condominioService.saveCondominio(this.condominio)
      .subscribe(resultado => {
        this.router.navigate(['condominios'])
      })
  }


}
