import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { ListaContatoComponent } from "./components/lista-contato/lista-contato.component";
import { DetalheContatoComponent } from "./components/detalhe-contato/detalhe-contato.component";
import { FormularioComponent } from './components/formulario/formulario.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormularioComponent, ListaContatoComponent, DetalheContatoComponent, RouterOutlet, RouterModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'contatos';
}
