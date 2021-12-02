import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../model/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  listar(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>('http://localhost:8080/orlando/webapi/usuario');
  }

  inserir(usuario: Usuario): Observable<void>{
    return this.http.post<void>('http://localhost:8080/orlando/webapi/usuario', usuario);
  }

  atualizar(usuario: Usuario): Observable<void>{
    return this.http.put<void>('http://localhost:8080/orlando/webapi/usuario', usuario);
  }

  excluir(id: number): Observable<void>{
    let parametro = new HttpParams();
    parametro = parametro.append('id', id)
    return this.http.delete<void>('http://localhost:8080/orlando/webapi/usuario', {params: parametro});
  }
}
