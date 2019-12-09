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
    console.log('save course...')
    console.log(this.course);
    this.save();
    if (this.selectedFile) {
      this.uploadFile();
    }
  }

  public onFileChanged(event): void {
    console.log(event);
    this.selectedFile = event.target.files.item(0);
  }

  private save() {
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
          console.log("... uploadFile response: ");
          console.log(response);
          if (response instanceof HttpResponse) {
            console.log(response.body);
          }
          //this.receivedImageData = res;
          //this.base64Data = this.receivedImageData.pic;
          //this.convertedImage = 'application/pdf,' + this.base64Data;
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
        console.log(data);
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
        console.log(data);
        this.levels = data;
      },
        error => console.error(error));
  }

  private gotoCourseList() {
    this.router.navigate(['courses-list']);
  }
}
