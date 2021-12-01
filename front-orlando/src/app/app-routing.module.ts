import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AvaliacaoComponent } from './views/avaliacao/avaliacao.component';
import { CadastroComponent } from './views/cadastro/cadastro.component';
import { CompraComponent } from './views/compra/compra.component';
import { FormularioComponent } from './views/formulario/formulario.component';
import { LoginComponent } from './views/login/login.component';
import { MenuComponent } from './views/menu/menu.component';

const routes: Routes = [
  {
    path: 'menu',
    component: MenuComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'formulario',
    component: FormularioComponent
  },
  {
    path: 'compra',
    component: CompraComponent
  },
  {
    path: 'cadastro',
    component: CadastroComponent
  },
  {
    path: 'avaliacao',
    component: AvaliacaoComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
