import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-formulario',
  standalone: true,
  imports: [FormsModule],
  template: `
    <div class="container">
      <form (submit)="onSubmit($event)">
        <input type="text" placeholder="Nome">
        <input type="email" placeholder="Email">
        <button type="submit">Salvar</button>
      </form>
    </div>
  `,
  styleUrl: "./formulario.component.css"
})
export class FormularioComponent {
  onSubmit(event: Event) {
    event.preventDefault();
    console.log('Formulário enviado');
  }
}