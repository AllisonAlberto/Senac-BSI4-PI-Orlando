import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './views/menu/menu.component';
import { LoginComponent } from './views/login/login.component';
import { FormularioComponent } from './views/formulario/formulario.component';
import { CompraComponent } from './views/compra/compra.component';
import { CadastroComponent } from './views/cadastro/cadastro.component';
import { AvaliacaoComponent } from './views/avaliacao/avaliacao.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    LoginComponent,
    FormularioComponent,
    CompraComponent,
    CadastroComponent,
    AvaliacaoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
