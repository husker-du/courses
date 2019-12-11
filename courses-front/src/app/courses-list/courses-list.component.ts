import { Component, OnInit, ViewChild } from '@angular/core';
import { Course } from "../model/course";
import { SubjectFile } from "../model/subject-file";
import { CourseService } from "../service/course.service";
import { FileService } from "../service/file.service";
import { DataService } from "../service/data.service";
import { MatTableDataSource, MatSort, MatPaginator } from "@angular/material";
import { MatSnackBar } from '@angular/material/snack-bar';
import * as FileSaver from "file-saver";

@Component({
  selector: 'app-courses-list',
  templateUrl: './courses-list.component.html',
  styleUrls: ['./courses-list.component.css']
})
export class CoursesListComponent implements OnInit {

  private title: string = "Catálogo de Cursos";

  // Table data
  private displayedColumns: string[] = ['title', 'teacher', 'level', 'hours', 'download'];
  private dataSource: MatTableDataSource<Course>;

  // Paginator inputs
  private pageSizeOptions: number[] = [4, 8, 12, 20];

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(
    private courseService: CourseService,
    private fileService: FileService,
    private fileSnackBar: MatSnackBar,
    private data: DataService) { }

  ngOnInit() {
    this.init();
  }

  public downloadFile(idFile: number): void {
    console.log("Downloading file "+ idFile + "...");
    this.fileService.downloadFile(idFile)
      .subscribe(data => {
          let subjectFile: SubjectFile = data;
          // Encode data to Base64
          let fileData = this.fileService.b64toBlob(subjectFile.data, subjectFile.type);

          // Save the file
          FileSaver.saveAs(fileData, subjectFile.fileName);

          // Update the file name in the snack bar component
          this.data.changeFileName(subjectFile.fileName);
          this.fileSnackBar.openFromComponent(SnackFileComponent, {
             duration: 5000,
          });
      },
        error => console.error(error));
  }

  private init(): void {
    this.courseService.getAllCourses()
      .subscribe(data => {
          this.dataSource = new MatTableDataSource<Course>(data);
           // Set the paginator and sort after the view init since this component will
           // be able to query its view for the initialized paginator and sort.
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
        },
        error => console.error(error));
  }
}

@Component({
  selector: 'file-snack-bar',
  template: '<mat-icon matSuffix style="color:coral">arrow_downward</mat-icon> Download file <span style="color:yellow">{{ fileName }}</span>',
  styles: [],
})
export class SnackFileComponent implements OnInit {
  private fileName: string;

  constructor(
    private data: DataService) { }

  ngOnInit(): void {
    this.data.currentFileName.subscribe(message => this.fileName = message)
  }
}
