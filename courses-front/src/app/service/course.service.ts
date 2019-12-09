import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Course } from "../model/course";
import { Teacher } from "../model/teacher";

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private static readonly API_ENDPOINT: string = 'http://localhost:8001/courses-catalogue/api/v2';

  constructor(
    private http: HttpClient
  ) { }

  public getAllCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(CourseService.API_ENDPOINT + '/courses');
  }

  public createCourse(course: Course): Observable<any> {
    return this.http.post(CourseService.API_ENDPOINT + '/courses', course );
  }

  public getAllTeachers(): Observable<Teacher[]> {
    return this.http.get<Teacher[]>(CourseService.API_ENDPOINT + '/teachers');
  }

  public getAllLevels(): Observable<string[]> {
    return this.http.get<string[]>(CourseService.API_ENDPOINT + '/levels');
  }
}
