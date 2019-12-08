import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CoursesListComponent } from './courses-list/courses-list.component';
import { CoursesAddComponent } from './courses-add/courses-add.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
  { path: 'courses-list', component: CoursesListComponent },
  { path: 'courses-add', component: CoursesAddComponent },
  { path: '', redirectTo: 'courses-list', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
