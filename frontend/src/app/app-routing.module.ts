import { SearchAppComponent } from './modules/cnes/pesquisar/search.app.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewAppComponent } from './modules/cnes/visualizar/view.app.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'admin',
    pathMatch: 'full'
  },
  {
    path: 'admin/cnes',
    component: SearchAppComponent
  },
  {
    path: 'admin/cnes/visualizar/:id',
    component: ViewAppComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
