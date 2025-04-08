import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AlunosServiceService } from '../services/alunos-service.service';

@Component({
  selector: 'app-formulario',
  standalone: true,
  imports: [FormsModule, CommonModule],
  template: `
    <div class="container">
      <form (submit)="onSubmit($event)" autocomplete="off">
        <input type="text" name="nome" placeholder="Nome" [(ngModel)]="nome" autocomplete="off">
        <button type="submit">Adicionar</button>
      </form>
      
      <div class="lista-alunos">
        <h3>Lista de Alunos</h3>
        <div>
          <div *ngIf="alunos.length === 0">
            Nenhum aluno cadastrado.
          </div>
          
          <ul *ngIf="alunos.length > 0">
            <li *ngFor="let aluno of alunos">{{ aluno }}</li>
          </ul>
        </div>
      </div>
      
    </div>
  `,
  styleUrl: "./formulario.component.css"
})
export class FormularioComponent {
  nome: string = "";
  alunos: string[] = [];

  constructor(private alunosService:AlunosServiceService) {
  }

  onSubmit(event: Event) {
    event.preventDefault();
    
    if (this.nome.trim()) {
      this.alunosService.addAluno(this.nome);
      this.alunos = this.alunosService.getAlunos();
      this.nome = "";
    }
  }
}