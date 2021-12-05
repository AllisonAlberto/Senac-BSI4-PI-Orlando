import { Component, OnInit } from '@angular/core';
import { Venda } from 'src/app/model/venda';
import { VendaService } from 'src/app/services/venda.service';

@Component({
  selector: 'app-venda',
  templateUrl: './venda.component.html',
  styleUrls: ['./venda.component.css']
})
export class VendaComponent implements OnInit {
  venda = new Array<Venda>();
  vendaEdicao?: Venda = undefined;
  estaEditando = false;

  constructor(private vendaService: VendaService) { }

  ngOnInit(): void {
    this.listar();
  }

  listar(): void{
    this.vendaService.listar().subscribe(venda => {
      this.venda = venda;
    });
  }

  salvar(): void{
    if(this.vendaEdicao == undefined){
      return;
    }
    if(!this.estaEditando){
      this.vendaService.inserir(this.vendaEdicao).subscribe(() => {
        this.listar();
        this.cancelar();
      });
    }
    else {
      this.vendaService.atualizar(this.vendaEdicao).subscribe(() => {
        this.listar();
        this.cancelar();
      });
    }
  }

  novoVenda() {
    this.vendaEdicao = new Venda();
    this.estaEditando = false;
  }

  cancelar() {
    this.vendaEdicao = undefined;
    this.estaEditando = false;
  }

  selecionarVenda(venda: Venda) {
    this.vendaEdicao = venda;
    this.estaEditando = true;
  }

  excluir(venda: Venda){
    const resposta = confirm(`${venda.produto} será excluido.`);
    if(resposta && venda && venda.id){
      this.vendaService.excluir(venda.id).subscribe(() => {
        this.listar();
      });
    }
  }

}
