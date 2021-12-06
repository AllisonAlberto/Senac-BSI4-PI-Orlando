import { Usuario } from 'src/app/model/usuario';
import { Categoria } from 'src/app/model/categoria';
export class Avaliacao {
  id?: number;
  titulo?: string;
  usuario = new Usuario();
  categoria = new Categoria();
  comentario?: string;
  nota?: number;
  duracao?: number;
  valor?: number;
  dataAtividade?: string;

}
