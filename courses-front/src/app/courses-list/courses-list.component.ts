import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Course } from "../model/course";
import { CourseService } from "../service/course.service";

@Component({
  selector: 'app-courses-list',
  templateUrl: './courses-list.component.html',
  styleUrls: ['./courses-list.component.css']
})
export class CoursesListComponent implements OnInit {

  private title: string = "Catálogo de Cursos";

  // Table data
  private displayedColumns: string[] = ['title', 'teacher', 'level', 'hours'];
  private courses: Course[];
  private dataSource: Course[];

  // Paginator inputs
  private length: number = 0;
  private pageSize: number = 4;
  private pageSizeOptions: number[] = [2, 4, 10, 20];
  private fromIndex: number = 0;
  private toIndex: number = this.pageSize;

  constructor(
    private courseService: CourseService) { }

  ngOnInit() {
    this.init();
  }

  private init() {
    this.courseService.getAllCourses()
      .subscribe(data => {
          this.courses = data;
          this.length = this.courses.length;
          this.loadPage();
        },
        error => console.error(error));
  }

  private loadPage() {
    this.dataSource = this.courses.slice(this.fromIndex, this.toIndex);
  }

  public onPageEvent(pEvent: PageEvent) {
    this.fromIndex = pEvent.pageIndex * pEvent.pageSize;
    this.toIndex = this.fromIndex + pEvent.pageSize;
    this.loadPage();
  }

}
