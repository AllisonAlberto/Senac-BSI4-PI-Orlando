import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/model/cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {
  clientes = new Array<Cliente>();
  clienteEdicao?: Cliente = undefined;
  estaEditando = false;

  constructor(private clienteService: ClienteService) { }

  ngOnInit(): void {
    this.listar();
  }

  listar(): void{
    this.clienteService.listar().subscribe(clientes => {
      this.clientes = clientes;
    });
  }

  salvar(): void{
    if(this.clienteEdicao == undefined){
      return;
    }
    if(!this.estaEditando){    
      this.clienteService.inserir(this.clienteEdicao).subscribe(() => {
        this.listar();
        this.cancelar();
      });
    }
    else {
      this.clienteService.atualizar(this.clienteEdicao).subscribe(() => {
        this.listar();
        this.cancelar();
      });
    }
  }

  novoCliente() {
    this.clienteEdicao = new Cliente();
    this.estaEditando = false;
  }

  cancelar() {
    this.clienteEdicao = undefined;
    this.estaEditando = false;
  }

  selecionarCliente(cliente: Cliente) {
    this.clienteEdicao = cliente;
    this.estaEditando = true;
  }

  excluir(cliente: Cliente){
    const resposta = confirm(`${cliente.nome} será excluido.`);
    if(resposta && cliente && cliente.id){
      this.clienteService.excluir(cliente.id).subscribe(() => {
        this.listar();
      });
    }
  }

}
