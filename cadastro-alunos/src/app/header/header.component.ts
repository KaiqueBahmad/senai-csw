import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [],
  template: `
    <header>
      <h1>Cadastro de Alunos</h1>
    </header>
  `,
  styles: `
    header {
      display: flex;
      align-items: center;
      justify-content: center;
      
      background-color: #2F195F;
      color: white;
      width: 100%;
      height: 5vw;
    }
  `
})
export class HeaderComponent {

}
