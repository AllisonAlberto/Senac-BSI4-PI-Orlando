import { AvaliacaoService } from './../../services/avaliacao.service';
import { Avaliacao } from './../../model/avaliacao';
import { Component, OnInit } from '@angular/core';
import { Categoria } from 'src/app/model/categoria';
import { Usuario } from 'src/app/model/usuario';
import { CategoriaService } from 'src/app/services/categoria.service';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-avaliacao',
  templateUrl: './avaliacao.component.html',
  styleUrls: ['./avaliacao.component.css']
})
export class AvaliacaoComponent implements OnInit {
  avaliacao = new Array<Avaliacao>();
  categorias = new Array<Categoria>();
  usuarios = new Array<Usuario>();
  avaliacaoEdicao?: Avaliacao = undefined;
  estaEditando = false;

  constructor(private avaliacaoService: AvaliacaoService, private categoriaService: CategoriaService, private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.listar();
    this.listarCategorias();
    this.listarUsuarios();
  }

  listar(): void{
    this.avaliacaoService.listar().subscribe(avaliacao => {
      this.avaliacao = avaliacao;
    });
  }

  salvar(): void{
    if(this.avaliacaoEdicao == undefined){
      return;
    }
    if(!this.estaEditando){
      this.avaliacaoService.inserir(this.avaliacaoEdicao).subscribe(() => {
        this.listar();
        this.cancelar();
      });
    }
    else {
      this.avaliacaoService.atualizar(this.avaliacaoEdicao).subscribe(() => {
        this.listar();
        this.cancelar();
      });
    }
  }

  novoAvaliacao() {
    this.avaliacaoEdicao = new Avaliacao();
    this.estaEditando = false;
  }

  cancelar() {
    this.avaliacaoEdicao = undefined;
    this.estaEditando = false;
  }

  selecionarAvaliacao(avaliacao: Avaliacao) {
    this.avaliacaoEdicao = avaliacao;
    this.estaEditando = true;
  }

  excluir(avaliacao: Avaliacao){
    const resposta = confirm(`${avaliacao.titulo} será excluido.`);
    if(resposta && avaliacao && avaliacao.id){
      this.avaliacaoService.excluir(avaliacao.id).subscribe(() => {
        this.listar();
      });
    }
  }

  listarCategorias(): void{
    this.categoriaService.listar().subscribe(categorias => {
      this.categorias = categorias;
    });
  }

  listarUsuarios(): void{
    this.usuarioService.listar().subscribe(usuarios => {
      this.usuarios = usuarios;
    });
  }


}
