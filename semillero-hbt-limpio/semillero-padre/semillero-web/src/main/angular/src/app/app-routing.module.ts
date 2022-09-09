import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsultarComicComponent } from './semillero/componentes/gestionar-comic/consultar-comic/consultar-comic.component';
import { GestionarComicComponent } from './semillero/componentes/gestionar-comic/gestionar-comic.component';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';

const routes: Routes = [
  { path: 'bienvenida', component: BienvenidaComponent},
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'consultar-comic', component: ConsultarComicComponent },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
