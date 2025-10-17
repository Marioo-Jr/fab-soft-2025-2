import { Component } from '@angular/core';
import { Espaco } from '../model/espaco';
import { EspacoService } from '../service/espaco.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-espaco',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './espaco.html',
  styleUrl: './espaco.css',
  providers:[EspacoService,Router]
})
export class EspacoComponent {

  listaEspacos: Espaco[] = []

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
  }

