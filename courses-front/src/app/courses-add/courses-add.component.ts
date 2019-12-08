import { Component, OnInit } from '@angular/core';
import { CourseService } from "../service/course.service";
import { Course } from "../model/course";
import { Router } from "@angular/router";

@Component({
  selector: 'app-courses-add',
  templateUrl: './courses-add.component.html',
  styleUrls: ['./courses-add.component.css']
})
export class CoursesAddComponent implements OnInit {

  private title: string = "Añadir Curso";

  private course: Course = new Course();

  private teachers: string[];

  private levels: string[];

  constructor(
    private courseService: CourseService,
    private router: Router
  ) { }

  ngOnInit() {
    this.loadData();
  }

  public onSubmit() {
    // Convert the boolean to byte (1 or 0)
    this.course.active = this.course.active ? 1 : 0;
    console.log(this.course);
    this.save();
  }

  private save() {
    this.courseService.createCourse(this.course)
      .subscribe(data => {
        console.log(data);
        this.course = new Course();
        this.gotoCourseList();
      },
        error => console.error(error));
  }

  private loadData() {
    this.loadTeachers();
    this.loadLevels();
  }

  private loadTeachers() {
    this.courseService.getAllTeachers()
      .subscribe(data => {
        console.log(data);
        this.teachers = data;
      },
        error => console.error(error));
  }

  private loadLevels() {
    this.courseService.getAllLevels()
      .subscribe(data => {
        console.log(data);
        this.levels = data;
      },
        error => console.error(error));
  }

  private gotoCourseList() {
    this.router.navigate(['courses-list']);
  }
}
