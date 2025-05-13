import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Grupo, GruposService } from '../../services/grupos-service.service';

@Component({
  selector: 'app-grupos-page',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div>
      <h2>Grupos</h2>
      
      <!-- Add new grupo form -->
      <div>
        <h3>Novo Grupo</h3>
        <input type="text" [(ngModel)]="novoGrupoNome" placeholder="Nome do grupo">
        <button (click)="adicionarGrupo()">Adicionar</button>
      </div>
      
      <!-- List of grupos -->
      <div>
        <h3>Lista de Grupos</h3>
        <div *ngFor="let grupo of grupos">
          <div (click)="selecionarGrupo(grupo.id)" style="padding: 5px; cursor: pointer; background-color: {{selectedGrupo?.id === grupo.id ? '#eee' : 'transparent'}}">
            <span>{{ grupo.nome }}</span>
            <button (click)="excluirGrupo(grupo.id); $event.stopPropagation();">X</button>
          </div>
        </div>
        
        <div *ngIf="grupos.length === 0">
          Nenhum grupo cadastrado
        </div>
      </div>
      
      <!-- Selected grupo details -->
      <div *ngIf="selectedGrupo">
        <h3>Detalhes do Grupo</h3>
        <p>Nome: {{ selectedGrupo.nome }}</p>
        <p>ID: {{ selectedGrupo.id }}</p>
        <button (click)="selecionarGrupo(undefined)">Voltar</button>
      </div>
    </div>
  `
})
export class GruposPageComponent implements OnInit {
  grupos: Grupo[] = [];
  selectedGrupo?: Grupo;
  novoGrupoNome: string = '';
  
  constructor(private gruposService: GruposService) {}
  
  ngOnInit(): void {
    // Subscribe to grupos list changes
    this.gruposService.gruposObservable.subscribe(grupos => {
      this.grupos = grupos;
    });
    
    // Subscribe to selected grupo changes
    this.gruposService.selectedObservable.subscribe(grupo => {
      this.selectedGrupo = grupo;
    });
    
    // Initial load of grupos
    this.gruposService.refresh();
  }
  
  selecionarGrupo(id?: number): void {
    this.gruposService.selectGrupo(id);
  }
  
  adicionarGrupo(): void {
    if (this.novoGrupoNome.trim()) {
      this.gruposService.addGrupo(this.novoGrupoNome);
      this.novoGrupoNome = ''; // Clear input field after adding
    }
  }
  
  excluirGrupo(id?: number): void {
    if (id !== undefined) {
      this.gruposService.excluir(id);
    }
  }
}