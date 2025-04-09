import { Component } from '@angular/core';
import { ContatosService } from '../../services/contatos.service';
import { Contato } from '../../interfaces/contato';

@Component({
  selector: 'app-detalhe-contato',
  standalone: true,
  imports: [],
  templateUrl: './detalhe-contato.component.html',
  styleUrl: './detalhe-contato.component.css'
})
export class DetalheContatoComponent {
  selected?:Contato;
  constructor(private contatosService:ContatosService) {
     contatosService.selectedObservable.subscribe(
      (newSelected) => {
        this.selected = newSelected;
      }
    );
  }

  excluir(id: number|undefined) {
    this.contatosService.excluir(id);
  }

}
