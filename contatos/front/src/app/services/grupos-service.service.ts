import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment.development';

export interface Grupo {
  id?: number;
  nome: string;
}

@Injectable({
  providedIn: 'root'
})
export class GruposService {
  private selectedSubject: Subject<Grupo | undefined> = new Subject<Grupo | undefined>();
  selectedObservable: Observable<Grupo | undefined> = this.selectedSubject.asObservable();

  private gruposSubject: BehaviorSubject<Grupo[]> = new BehaviorSubject<Grupo[]>([]);
  gruposObservable: Observable<Grupo[]> = this.gruposSubject.asObservable();

  constructor(private httpClient: HttpClient) {
    this.refresh();
  }

  public addGrupo(nomeGrupo: string): void {
    this.httpClient.post<any>(environment.API_URL + "/grupos", {nome: nomeGrupo}).subscribe(
      () => {
        this.refresh();
      }
    );
  }

  public selectGrupo(id?: number) {
    if (id === undefined) {
      this.selectedSubject.next(undefined);
      return;
    }
    
    this.selectedSubject.next(this.gruposSubject.value.find(
      (grupo) => {
        return grupo.id == id;
      }
    ));
  }

  public excluir(id: number | undefined) {
    this.httpClient.delete<any>(environment.API_URL + '/grupos/' + id).subscribe(
      () => {
        this.selectedSubject.next(undefined);
        this.refresh();
      }
    );
  }

  public refresh() {
    this.httpClient.get<Grupo[]>(environment.API_URL + '/grupos').subscribe(
      (grupos) => {
        this.gruposSubject.next(grupos);
      }
    );
  }
}