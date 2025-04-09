import { Routes } from '@angular/router';
import { FormularioComponent } from './components/formulario/formulario.component';
import { ListaContatoComponent } from './components/lista-contato/lista-contato.component';
import { DetalheContatoComponent } from './components/detalhe-contato/detalhe-contato.component';
import { ListaLayoutComponent } from './components/lista-layout/lista-layout.component';

export const routes: Routes = [
    {
        path: "lista",
        component: ListaLayoutComponent
    },
    {
        path: "form",
        component: FormularioComponent
    },
    {
        path:"",
        component: FormularioComponent
    }
];
