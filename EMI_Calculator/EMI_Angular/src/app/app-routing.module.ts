import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ListComponent } from './list/list.component';


const routes: Routes = [{path:'', component: ListComponent},
{path:'list', component: ListComponent},
{path:'**', redirectTo: '/list', pathMatch: 'full'}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
