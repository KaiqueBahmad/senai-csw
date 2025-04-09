import { Injectable } from '@angular/core';
import { Contato } from '../interfaces/contato';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContatosService {
  private COUNTER: number = 3;
  contatos: Contato[] = [
    {
      id: 1,
      email: "kaiquebahmadt@gmail.com",
      nome: "Kaique",
      telefone: "62985250032"
    },
    {
      id: 2,
      email:"teste@gmail.com",
      nome: "Teste",
      telefone: "62995487756"
    }
  ];
  private selectedSubject: Subject<Contato| undefined> = new Subject<Contato|undefined>();
  selectedObservable: Observable<Contato | undefined> = this.selectedSubject.asObservable();

  


  constructor() { }
  public addContato(contato: Contato) {
    if (!contato.email || !contato.nome || !contato.telefone) {
      alert("Preencha a todos atributos")
      return;
    }
    contato.id = this.COUNTER++;
    this.contatos.push(contato);
  }
  public selectContato(id?:number) {
    if (id === undefined) {
      this.selectedSubject.next(undefined);
    }
    this.selectedSubject.next(this.contatos.find(
      (cont) => {
        return cont.id == id;
      }
    ));
  }

  excluir(id: number | undefined) {
    this.contatos = this.contatos.filter((x) => {
      return x.id !== id;
    });
    this.selectedSubject.next(undefined);
  }

}
