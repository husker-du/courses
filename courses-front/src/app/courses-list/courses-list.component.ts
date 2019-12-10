import { Component, OnInit, ViewChild } from '@angular/core';
import { Course } from "../model/course";
import { CourseService } from "../service/course.service";
import { FileService } from "../service/file.service";
import { MatTableDataSource, MatSort, MatPaginator } from "@angular/material";
import {SubjectFile} from "../model/subject-file";

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
    private fileService: FileService) { }

  ngOnInit() {
    this.init();
  }

  doAction(idFile: number): void {
    console.log("Downloading file "+ idFile + "...");
    this.fileService.downloadFile(idFile)
      .subscribe(data => {
          console.log(".... file data");
          console.log(data);
          let subjectFile: SubjectFile = data;
      },
        error => console.error(error));
  }

  private init(): void {
    this.courseService.getAllCourses()
      .subscribe(data => {
          console.log("...... data");
          console.log(data);
          this.dataSource = new MatTableDataSource<Course>(data);
           // Set the paginator and sort after the view init since this component will
           // be able to query its view for the initialized paginator and sort.
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
        },
        error => console.error(error));
  }
}
