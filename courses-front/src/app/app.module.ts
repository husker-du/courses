import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule }   from '@angular/forms';
import { MaterialFileInputModule } from 'ngx-material-file-input';
import { MatButtonModule,
         MatPaginatorModule,
         MatTableModule,
         MatSortModule,
         MatCardModule,
         MatFormFieldModule,
         MatSelectModule,
         MatInputModule,
         MatCheckboxModule,
         MatToolbarModule,
         MatIconModule,
         MatSnackBarModule } from '@angular/material';

import { AppComponent } from './app.component';
import { CoursesListComponent, SnackFileComponent } from './courses-list/courses-list.component';
import { CoursesAddComponent } from './courses-add/courses-add.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    CoursesListComponent,
    CoursesAddComponent,
    PageNotFoundComponent,
    SnackFileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    MaterialFileInputModule,
    MatButtonModule,
    MatPaginatorModule,
    MatTableModule,
    MatSortModule,
    MatCardModule,
    MatFormFieldModule,
    MatSelectModule,
    MatCheckboxModule,
    MatInputModule,
    MatToolbarModule,
    MatIconModule,
    MatSnackBarModule
  ],
  entryComponents: [SnackFileComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
