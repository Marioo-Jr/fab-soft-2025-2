import { Routes } from '@angular/router';
import { EspacoComponent } from './espaco/espaco.component';
import { PessoaComponent } from './pessoa.component/pessoa.component';
import { FormEspaco } from './form-espaco/form-espaco';
import { FormPessoa } from './form-pessoa/form-pessoa';
import { LocacaoComponent } from './locacao.component/locacao.component';
import { FormLocacao } from './form-locacao/form-locacao';
import { ImovelComponent } from './imovel.component/imovel.component';
import { FormImovel } from './form-imovel/form-imovel';


export const routes: Routes = [

    // espacos
    {path:'espacos', component:EspacoComponent},
    {path:'espacos/novo', component:FormEspaco},
    {path:'espacos/alterar/:id', component:FormEspaco},
    
    // pessoas
    {path:'pessoas', component:PessoaComponent},
    {path:'pessoas/novo', component:FormPessoa},
    {path:'pessoas/alterar/:id', component:FormPessoa},

    // locacoes
    {path:'locacoes', component:LocacaoComponent},
    {path:'locacoes/novo', component:FormLocacao},
    {path:'locacoes/alterar/:id', component:FormLocacao},

    // Imoveis
    {path:'imoveis', component:ImovelComponent},
    {path:'imoveis/novo', component:FormImovel},
    {path:'imoveis/alterar/:id', component:FormImovel},


];
