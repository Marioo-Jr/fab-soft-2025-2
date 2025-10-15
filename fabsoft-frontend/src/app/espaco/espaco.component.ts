import { Component } from '@angular/core';
import { Espaco } from '../model/espaco';
import { EspacoService } from '../service/espaco.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-espaco',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './espaco.html',
  styleUrl: './espaco.css',
  providers:[EspacoService]
})
export class EspacoComponent {

  listaEspacos: Espaco[] = []

  constructor(private espacoService: EspacoService){}
    ngOnInit(){
      console.log('carregando espacos')
      this.espacoService.getEspacos().subscribe(espacos =>{
        this.listaEspacos = espacos
      })

    }
  }

