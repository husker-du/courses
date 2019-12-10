import { Component, OnInit } from '@angular/core';
import { CourseService } from "../service/course.service";
import { Course } from "../model/course";
import { Teacher } from "../model/teacher";
import { Router } from "@angular/router";
import { HttpResponse } from "@angular/common/http";
import { FileService } from "../service/file.service";

@Component({
  selector: 'app-courses-add',
  templateUrl: './courses-add.component.html',
  styleUrls: ['./courses-add.component.css']
})
export class CoursesAddComponent implements OnInit {

  private title: string = "Añadir Curso";

  private course: Course = new Course();

  private teachers: Teacher[] = [];

  private teacherNames: string[] = [] ;

  private levels: string[] = [];

  failed: boolean = false;

  selectedFile: File = null;

  constructor(
    private courseService: CourseService,
    private fileService: FileService,
    private router: Router) { }

  ngOnInit() {
    this.loadData();
  }

  public onSubmit(): void {
    // Convert the boolean to byte (1 or 0)
    this.course.active = this.course.active ? 1 : 0;
    if (this.selectedFile) {
      this.uploadFile();
    } else {
      this.saveCourse();
    }
  }

  public onFileChanged(event): void {
    this.selectedFile = event.target.files.item(0);
    console.log(this.selectedFile);
  }

  private saveCourse() {
    this.courseService.createCourse(this.course)
      .subscribe(response => {
        if (response instanceof HttpResponse) {
          console.log(response.body);
        }
        this.course = new Course();
        this.gotoCourseList();
      },
        error => {
        console.error(error);
        this.failed = true;
      });
  }

  private uploadFile(): void {
    this.fileService.uploadFile(this.selectedFile)
      .subscribe ( response => {
          if (response instanceof HttpResponse && response.ok) {
            // Set the file id to the course object
            this.course.idFile = this.getIdFile(String(response.body));
            this.saveCourse();
          }
        },
        error => console.error(error)
      );
  }

  private loadData() {
    this.loadTeachers();
    this.loadLevels();
  }

  private loadTeachers() {
    this.courseService.getAllTeachers()
      .subscribe(data => {
        this.teachers = data;
        this.teachers.forEach(teacher =>
            this.teacherNames.push(teacher.firstName + ' ' + teacher.lastName)
        );
      },
        error => console.error(error));
  }

  private loadLevels() {
    this.courseService.getAllLevels()
      .subscribe(data => {
        this.levels = data;
      },
        error => console.error(error));
  }

  private gotoCourseList() {
    this.router.navigate(['courses-list']);
  }

  private getIdFile(body: string): number {
    let idFile: number = 0;
    let re = new RegExp('id_file:\\s*(\\d)');
    let match = re.exec(body);
    if (match.length >= 1) {
      idFile = parseInt(match[1]);
    }
    return idFile;
  }
}
