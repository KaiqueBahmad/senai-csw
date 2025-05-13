import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Contato } from '../../interfaces/contato';
import { ContatosService } from '../../services/contatos.service';

import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';
import { InputMaskModule } from 'primeng/inputmask';
import { MultiSelectModule } from 'primeng/multiselect';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-formulario',
  standalone: true,
  imports: [
    FormsModule,
    CommonModule,
    CardModule,
    InputTextModule,
    ButtonModule,
    ToastModule,
    InputMaskModule,
    MultiSelectModule
  ],
  providers: [MessageService],
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css'
})
export class FormularioComponent {
  contato: Contato = {
    email: undefined,
    id: undefined,
    nome: undefined,
    telefone: undefined,
    grupos: undefined
  }

  gruposDisponiveis = [
    { nome: 'Trabalho', codigo: 'trabalho' },
    { nome: 'Família', codigo: 'familia' },
    { nome: 'Amigos', codigo: 'amigos' },
    { nome: 'Favoritos', codigo: 'favoritos' }
  ];

  constructor(
    private contatosService: ContatosService,
    private messageService: MessageService
  ) {}

  enviar() {
    if (this.validarFormulario()) {
      this.contatosService.addContato(this.contato);
      this.messageService.add({
        severity: 'success',
        summary: 'Sucesso',
        detail: 'Contato adicionado com sucesso!'
      });
      this.limpar();
    }
  }

  limpar() {
    this.contato = {
      email: undefined,
      id: undefined,
      nome: undefined,
      telefone: undefined,
      grupos: undefined
    };
  }

  validarFormulario(): boolean {
    if (!this.contato.nome) {
      this.messageService.add({
        severity: 'error',
        summary: 'Erro',
        detail: 'Nome é obrigatório'
      });
      return false;
    }

    if (!this.contato.email) {
      this.messageService.add({
        severity: 'error',
        summary: 'Erro',
        detail: 'Email é obrigatório'
      });
      return false;
    }

    return true;
  }
}