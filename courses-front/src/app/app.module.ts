import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule }   from '@angular/forms';

import { AppComponent } from './app.component';
import { CoursesListComponent } from './courses-list/courses-list.component';
import { CoursesAddComponent } from './courses-add/courses-add.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { MatButtonModule,
         MatPaginatorModule,
         MatTableModule,
         MatCardModule,
         MatFormFieldModule,
         MatSelectModule,
         MatInputModule,
         MatCheckboxModule,
         MatToolbarModule } from '@angular/material';

@NgModule({
  declarations: [
    AppComponent,
    CoursesListComponent,
    CoursesAddComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    MatButtonModule,
    MatPaginatorModule,
    MatTableModule,
    MatCardModule,
    MatFormFieldModule,
    MatSelectModule,
    MatCheckboxModule,
    MatInputModule,
    MatToolbarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
