import { Component } from '@angular/core';

@Component({
  selector: 'app-info-projeto',
  standalone: true,
  imports: [],
  template: `
    <div class="container">
      <h2>Sobre o projeto</h2>
      <p>
        Este é um sistema para guardar nomes de alunos.
        Você pode adicionar nomes na página de formulário e ver todos eles listados.
      </p>
      <p>
        Usando angular, rotas, renderização de listas, reações onclick
      </p>
    </div>
  `,
  styleUrl: "./info-projeto.component.css"
})
export class InfoProjetoComponent {

}