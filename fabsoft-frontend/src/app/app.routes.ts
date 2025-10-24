import { Routes } from '@angular/router';
import { EspacoComponent } from './espaco/espaco.component';

import { FormEspaco } from './form-espaco/form-espaco';

export const routes: Routes = [
    {path:'espacos', component:EspacoComponent},
    {path:'espacos/novo', component:FormEspaco},
    {path:'espacos/alterar/:id', component:FormEspaco}

];
