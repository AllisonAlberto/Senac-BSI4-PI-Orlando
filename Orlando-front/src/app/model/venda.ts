import { Cliente } from 'src/app/model/cliente';
export class Venda {
  id?: number;
  cliente = new Cliente();
  produto?: string;
  preco?: number;
  dataVenda?: string;
}
