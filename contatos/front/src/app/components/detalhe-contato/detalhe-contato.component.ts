import { Component } from '@angular/core';
import { ContatosService } from '../../services/contatos.service';
import { Contato } from '../../interfaces/contato';
import { CommonModule } from '@angular/common';
import { GruposService } from '../../services/grupos-service.service';

@Component({
  selector: 'app-detalhe-contato',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="common-content" style="background-color: purple;flex-direction: column;">
      <p>detalhe contato</p>
      @if (selected) {
        <p>NOME: {{selected.nome}}</p>
        <button (click)="excluir(selected.id)">Excluir</button>
        <button (click)="toggleFavorito(selected)">
          {{selected.favorito ? 'Remover Favorito' : 'Favoritar'}}
        </button>
        
        <!-- Grupos do contato -->
        <div>
          <p>Grupos:</p>
          @if (selected.grupos && selected.grupos.length > 0) {
            @for (grupo of selected.grupos; track grupo.id) {
              <div>
                {{grupo.nome}}
                <button (click)="removerDoGrupo(selected.id, grupo.id)">X</button>
              </div>
            }
          } @else {
            <p>Nenhum grupo</p>
          }
        </div>
        
        <!-- Toggle para mostrar grupos disponíveis -->
        <button (click)="mostrarGrupos = !mostrarGrupos">
          {{mostrarGrupos ? 'Ocultar Grupos' : 'Adicionar a Grupo'}}
        </button>
        
        <!-- Lista de grupos para adicionar -->
        @if (mostrarGrupos) {
          <div>
            @for (grupo of gruposDisponiveis; track grupo.id) {
              <div>
                {{grupo.nome}}
                <button (click)="adicionarAoGrupo(selected.id, grupo.id)">+</button>
              </div>
            }
            @if (gruposDisponiveis.length === 0) {
              <p>Não há grupos disponíveis</p>
            }
          </div>
        }
      }
    </div>
  `,
})
export class DetalheContatoComponent {
  selected?: Contato;
  mostrarGrupos: boolean = false;
  gruposDisponiveis: any[] = [];
  
  constructor(
    private contatosService: ContatosService,
    private gruposService: GruposService
  ) {
    contatosService.selectedObservable.subscribe(
      (newSelected) => {
        this.selected = newSelected;
        this.atualizarGruposDisponiveis();
      }
    );
    
    // Subscribe to grupos changes
    gruposService.gruposObservable.subscribe(() => {
      this.atualizarGruposDisponiveis();
    });
    
    // Load grupos
    gruposService.refresh();
  }
  
  excluir(id: number|undefined) {
    this.contatosService.excluir(id);
  }
  
  toggleFavorito(contato: Contato) {
    this.contatosService.toggleFavorito(contato);
  }
  
  adicionarAoGrupo(contatoId?: number, grupoId?: number) {
    if (contatoId && grupoId) {
      this.contatosService.adicionarContatoAGrupo(contatoId, grupoId);
      // Refresh to update the UI
      setTimeout(() => {
        this.contatosService.refresh();
        this.gruposService.refresh();
      }, 100);
    }
  }
  
  removerDoGrupo(contatoId?: number, grupoId?: number) {
    if (contatoId && grupoId) {
      this.contatosService.removerContatoDeGrupo(contatoId, grupoId);
      // Refresh to update the UI
      setTimeout(() => {
        this.contatosService.refresh();
        this.gruposService.refresh();
      }, 100);
    }
  }
  
  atualizarGruposDisponiveis() {
    if (!this.selected) {
      this.gruposDisponiveis = [];
      return;
    }
    
    this.gruposService.gruposObservable.subscribe(grupos => {
      // Filter grupos that the contact is not already in
      this.gruposDisponiveis = grupos.filter(grupo => 
        !this.selected?.grupos || !this.selected.grupos.some(g => g.id === grupo.id)
      );
    });
  }
}