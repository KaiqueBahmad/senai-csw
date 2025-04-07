import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from "./header/header.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent],
  template: `
  <div class="app-container">
    <app-header></app-header>
    <main class="content-area">
      <router-outlet></router-outlet>
    </main>
  </div>
  `,
  styleUrl: "./app.component.css"
 })
 export class AppComponent {
  title = 'cadastro-alunos';
 }
