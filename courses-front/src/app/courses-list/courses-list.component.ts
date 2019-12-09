import { Component, OnInit, ViewChild } from '@angular/core';
import { Course } from "../model/course";
import { CourseService } from "../service/course.service";
import { MatTableDataSource, MatSort, MatPaginator } from "@angular/material";

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
    private courseService: CourseService) { }

  ngOnInit() {
    this.init();
  }

  doAction(teacher: string): void {
    console.log("Descargando "+ teacher + "...");
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
