import { Routes } from '@angular/router';
import { FormularioComponent } from './formulario/formulario.component';
import { InfoProjetoComponent } from './info-projeto/info-projeto.component';

export const routes: Routes = [
    {
        path: "formulario",
        component: FormularioComponent   
    },
    {
        path:"",
        component: FormularioComponent
    },
    {
        path:"info",
        component: InfoProjetoComponent
    }

];
