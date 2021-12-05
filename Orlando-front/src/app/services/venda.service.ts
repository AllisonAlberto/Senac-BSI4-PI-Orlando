import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Venda } from '../model/venda';

@Injectable({
  providedIn: 'root'
})
export class VendaService {

  constructor(private http: HttpClient) { }

  listar(): Observable<Venda[]> {
    return this.http.get<Venda[]>('http://localhost:8080/orlando/webapi/venda');
  }

  inserir(venda: Venda): Observable<void>{
    return this.http.post<void>('http://localhost:8080/orlando/webapi/venda', venda);
  }

  atualizar(venda: Venda): Observable<void>{
    return this.http.put<void>('http://localhost:8080/orlando/webapi/venda', venda);
  }

  excluir(id: number): Observable<void>{
    let parametro = new HttpParams();
    parametro = parametro.append('id', id)
    return this.http.delete<void>('http://localhost:8080/orlando/webapi/venda', {params: parametro});
  }

}
