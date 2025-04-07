import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [],
  template: `
    <header>
      <h1>Cadastro de Alunos</h1>
      <div style="display: flex; gap: 5px;">
        <a href="/info" style="color: white;">ver informações</a>
        <a href="/formulario" style="color: white;">lista de alunos</a>
      </div>
    </header>
  `,
  styles: `
    header {
      display: flex;
      align-items: center;
      justify-content: center;
      flex-direction: column;
      
      background-color: #2F195F;
      color: white;
      width: 100%;
      height: 5vw;
    }
  `
})
export class HeaderComponent {

}
