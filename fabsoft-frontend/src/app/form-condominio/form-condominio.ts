import { Component } from '@angular/core';
import { Condominio } from '../model/condominio';
import { CondominioService } from '../service/condominio.service';
import { HttpClientModule } from '@angular/common/http'; 
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Pessoa } from '../model/pessoa';
import { PessoaService } from '../service/pessoa.service';


@Component({
  selector: 'app-form-condominio',
  imports: [HttpClientModule,CommonModule,FormsModule],
  templateUrl: './form-condominio.html',
  styleUrl: './form-condominio.css',
  //providers: [CondominioService, Router]
})
export class FormCondominio {

  condominio: Condominio = new Condominio();
  listaDePessoas: Pessoa[] = [];

  constructor(
    private condominioService: CondominioService,
    private pessoaService: PessoaService,
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

    ngOnInit(){
      this.pessoaService.getPessoas().subscribe(page => {
          this.listaDePessoas = page.content;
      });
  }
  comparaPessoas (obj1: Pessoa, obj2: Pessoa): boolean {
      return obj1 && obj2 ? obj1.id === obj2.id : obj1 === obj2;
  }

  salvar(){
    this.condominioService.saveCondominio(this.condominio)
      .subscribe(resultado => {
        this.router.navigate(['condominios'])
      })
  }


}
