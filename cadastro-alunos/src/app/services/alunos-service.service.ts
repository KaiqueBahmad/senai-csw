import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AlunosServiceService {
  alunos: string[] = [];

  public addAluno(nome:string) {
    this.alunos.push(nome);
  }
  public getAlunos(): string[] {
    return this.alunos;
  }

  constructor() { }
}
