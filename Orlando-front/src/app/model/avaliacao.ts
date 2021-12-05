import { Usuario } from 'src/app/model/usuario';
import { Categoria } from 'src/app/model/categoria';
export class Avaliacao {
  id?: number;
  titulo?: string;
  usuario?: Usuario["id"];
  categoria?: Categoria["id"];
  comentario?: string;
  nota?: number;
  duracao?: number;
  valor?: number;
  dtAtividade?: string;

}
