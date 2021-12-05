import { Component, OnInit } from '@angular/core';
import { Categoria } from 'src/app/model/categoria';
import { CategoriaService } from 'src/app/services/categoria.service';

@Component({
  selector: 'app-categoria',
  templateUrl: './categoria.component.html',
  styleUrls: ['./categoria.component.css']
})
export class CategoriaComponent implements OnInit {
  categorias = new Array<Categoria>();
  categoriaEdicao?: Categoria = undefined;
  estaEditando = false;

  constructor(private categoriaService: CategoriaService) { }

  ngOnInit(): void {
    this.listar();
  }

  listar(): void{
    this.categoriaService.listar().subscribe(categorias => {
      this.categorias = categorias;
    });
  }

  salvar(): void{
    if(this.categoriaEdicao == undefined){
      return;
    }
    if(!this.estaEditando){    
      this.categoriaService.inserir(this.categoriaEdicao).subscribe(() => {
        this.listar();
        this.cancelar();
      });
    }
    else {
      this.categoriaService.atualizar(this.categoriaEdicao).subscribe(() => {
        this.listar();
        this.cancelar();
      });
    }
  }

  novoCategoria() {
    this.categoriaEdicao = new Categoria();
    this.estaEditando = false;
  }

  cancelar() {
    this.categoriaEdicao = undefined;
    this.estaEditando = false;
  }

  selecionarCategoria(categoria: Categoria) {
    this.categoriaEdicao = categoria;
    this.estaEditando = true;
  }

  excluir(categoria: Categoria){
    const resposta = confirm(`${categoria.tipo} será excluido.`);
    if(resposta && categoria && categoria.id){
      this.categoriaService.excluir(categoria.id).subscribe(() => {
        this.listar();
      });
    }
  }
}
