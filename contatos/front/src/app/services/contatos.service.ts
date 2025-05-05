import { Injectable } from '@angular/core';
import { Contato } from '../interfaces/contato';
import { BehaviorSubject, Observable, Subject, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class ContatosService {
  private selectedSubject: Subject<Contato| undefined> = new Subject<Contato|undefined>();
  selectedObservable: Observable<Contato | undefined> = this.selectedSubject.asObservable();

  private contatosSubject: BehaviorSubject<Contato[]> = new BehaviorSubject<Contato[]>([]);
  contatosObservable: Observable<Contato[]> = this.contatosSubject.asObservable();

  constructor(private httpClient: HttpClient) {
    this.refresh();

  }
  public addContato(contato: Contato):void {
    contato.id = undefined;
    this.httpClient.post<any>(environment.API_URL+ "/contatos", contato).subscribe(
      () => {
        this.refresh();
      }
    );
  }
  public selectContato(id?:number) {
    if (id === undefined) {
      this.selectedSubject.next(undefined);
    }
    this.selectedSubject.next(this.contatosSubject.value.find(
      (cont) => {
        return cont.id == id;
      }
    ));
  }

  public excluir(id: number | undefined) {
    this.httpClient.delete<any>(environment.API_URL + '/contatos/'+id).subscribe(
      () => {
        this.selectedSubject.next(undefined);
        this.refresh();
      }
    );
  }

  public refresh() {
    this.httpClient.get<Contato[]>(environment.API_URL + '/contatos').subscribe(
      (x) => {
        this.contatosSubject.next(x);
      }
    );
  }
}
