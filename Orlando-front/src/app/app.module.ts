import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuarioComponent } from './paginas/usuario/usuario.component';
import { FormsModule } from '@angular/forms';
import { ClienteComponent } from './paginas/cliente/cliente.component';
import { CategoriaComponent } from './paginas/categoria/categoria.component';

@NgModule({
  declarations: [
    AppComponent,
    UsuarioComponent,
    ClienteComponent,
    CategoriaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
