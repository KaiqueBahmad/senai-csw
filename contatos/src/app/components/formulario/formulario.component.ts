import { Component } from '@angular/core';
import { ListaContatoComponent } from "../lista-contato/lista-contato.component";
import { FormsModule } from '@angular/forms';
import { Contato } from '../../interfaces/contato';
import { ContatosService } from '../../services/contatos.service';

@Component({
  selector: 'app-formulario',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css'
})
export class FormularioComponent {
  contato:Contato = {
    email: undefined,
    id: undefined,
    nome: undefined,
    telefone: undefined
  }

  constructor(private contatosService: ContatosService) {

  }

  enviar() {
    this.contatosService.addContato(this.contato);
    this.limpar();
  }
  
  limpar() {
    this.contato = {};
  }

}


