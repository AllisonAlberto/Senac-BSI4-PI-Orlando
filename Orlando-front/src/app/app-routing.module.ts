import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AvaliacaoComponent } from './paginas/avaliacao/avaliacao.component';
import { CategoriaComponent } from './paginas/categoria/categoria.component';
import { ClienteComponent } from './paginas/cliente/cliente.component';
import { UsuarioComponent } from './paginas/usuario/usuario.component';
import { VendaComponent } from './paginas/venda/venda.component';


const routes: Routes = [
  {
    path: 'usuario',
    component: UsuarioComponent
  },
  {
    path: 'cliente',
    component: ClienteComponent
  },
  {
    path: 'categoria',
    component: CategoriaComponent
  },
  {
    path: 'avaliacao',
    component: AvaliacaoComponent
  },
  {
    path: 'venda',
    component: VendaComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
