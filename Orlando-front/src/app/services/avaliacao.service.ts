import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Avaliacao } from '../model/avaliacao';

@Injectable({
  providedIn: 'root'
})
export class AvaliacaoService {

  constructor(private http: HttpClient) { }

  listar(): Observable<Avaliacao[]> {
    return this.http.get<Avaliacao[]>('http://localhost:8080/orlando/webapi/avaliacao');
  }

  inserir(avaliacao: Avaliacao): Observable<void>{
    return this.http.post<void>('http://localhost:8080/orlando/webapi/avaliacao', avaliacao);
  }

  atualizar(avaliacao: Avaliacao): Observable<void>{
    return this.http.put<void>('http://localhost:8080/orlando/webapi/avaliacao', avaliacao);
  }

  excluir(id: number): Observable<void>{
    let parametro = new HttpParams();
    parametro = parametro.append('id', id)
    return this.http.delete<void>('http://localhost:8080/orlando/webapi/avaliacao', {params: parametro});
  }

}
