import { Component } from '@angular/core';
import { ListaContatoComponent } from "../lista-contato/lista-contato.component";
import { DetalheContatoComponent } from "../detalhe-contato/detalhe-contato.component";

@Component({
  selector: 'app-lista-layout',
  standalone: true,
  imports: [ListaContatoComponent, DetalheContatoComponent],
  templateUrl: './lista-layout.component.html',
  styleUrl: './lista-layout.component.css'
})
export class ListaLayoutComponent {

}
