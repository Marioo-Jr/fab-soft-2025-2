import { Component } from '@angular/core';
import { Espaco } from '../model/espaco';
import { HttpClientModule } from '@angular/common/http';
import { EspacoService } from '../service/espaco.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

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
    private router:Router
  ){}

  salvar(){
  
    this.espacoService.saveEspaco(this.espaco).subscribe(resultado => {
        this.router.navigate(['espacos'])
      })
  }

}
