import { Component } from '@angular/core';
import { ContatosService } from '../../services/contatos.service';
import { Contato } from '../../interfaces/contato';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-lista-contato',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './lista-contato.component.html',
  styleUrl: './lista-contato.component.css'
})
export class ListaContatoComponent {
  contatos!: Contato[];
  constructor(private contatosService:ContatosService, private router: Router, private route: ActivatedRoute) {
    this.contatosService.selectedObservable.subscribe(
      (_) => {
        this.contatos = contatosService.contatos;
      }
    );
    this.contatos = contatosService.contatos;
  }
  
  openDetalhes(id?: number) {
    this.contatosService.selectContato(id);
  }
}
