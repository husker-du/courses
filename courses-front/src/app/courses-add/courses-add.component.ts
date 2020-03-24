import { Component, OnInit } from '@angular/core';
import { CourseService } from "../service/course.service";
import { Course } from "../model/course";
import { Teacher } from "../model/teacher";
import { Router } from "@angular/router";
import { HttpResponse } from "@angular/common/http";
import { FileService } from "../service/file.service";
import { SubjectFile } from "../model/subject-file";

@Component({
  selector: 'app-courses-add',
  templateUrl: './courses-add.component.html',
  styleUrls: ['./courses-add.component.css']
})
export class CoursesAddComponent implements OnInit {

  get levels(): string[] {
    return this._levels;
  }

  get teacherNames(): string[] {
    return this._teacherNames;
  }

  get title(): string {
    return this._title;
  }

  get course(): Course {
    return this._course;
  }

  private _title: string = "Añadir Curso";

  private _course: Course = new Course();

  private teachers: Teacher[] = [];

  private _teacherNames: string[] = [] ;

  private _levels: string[] = [];

  public failed: boolean = false;

  public selectedFile: File = null;

  constructor(
    private courseService: CourseService,
    private fileService: FileService,
    private router: Router) { }

  ngOnInit() {
    this.loadData();
  }

  public onSubmit(): void {
    // Convert the boolean to byte (1 or 0)
    this._course.active = this._course.active ? 1 : 0;
    if (this.selectedFile) {
      this.saveCourseWithFile();
    } else {
      this.saveCourse();
    }
  }

  public onFileChanged(event): void {
    this.selectedFile = event.target.files.item(0);
    console.log(this.selectedFile);
  }

  private saveCourseWithFile(): void {
    // Upload the subject file
    this.fileService.uploadFile(this.selectedFile)
      .subscribe ( response => {
          if (response instanceof HttpResponse && response.ok && response.body) {
            // Set the file id to the course object
            let file: SubjectFile = JSON.parse(response.body.toString());
            this._course.idFile = file.id;
            // Save the course data
            this.saveCourse();
          }
        },
        error => console.error(error)
      );
  }

  private saveCourse(): void {
    this.courseService.createCourse(this._course)
      .subscribe(response => {
          if (response instanceof HttpResponse) {
            console.log(response.body);
          }
          this._course = new Course();
          this.gotoCourseList();
        },
        error => {
          console.error(error);
          this.failed = true;
        });
  }

  private loadData(): void {
    this.loadTeachers();
    this.loadLevels();
  }

  private loadTeachers(): void {
    this.courseService.getAllTeachers()
      .subscribe(data => {
        this.teachers = data;
        this.teachers.forEach(teacher =>
            this._teacherNames.push(teacher.firstName + ' ' + teacher.lastName)
        );
      },
        error => console.error(error));
  }

  private loadLevels(): void {
    this.courseService.getAllLevels()
      .subscribe(data => {
        this._levels = data;
      },
        error => console.error(error));
  }

  private gotoCourseList(): void {
    this.router.navigate(['courses-list']);
  }
}
