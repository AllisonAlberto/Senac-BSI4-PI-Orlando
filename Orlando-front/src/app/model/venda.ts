import { Cliente } from 'src/app/model/cliente';
export class Venda {
  id?: number;
  cliente?: Cliente;
  produto?: string;
  preco?: number;
  dtVenda?: string;
}
