import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Course } from "../model/course";

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private static readonly API_ENDPOINT: string = 'http://localhost:8001/courses-catalogue/api/v1';

  constructor(
    private http: HttpClient) { }

  public getAllCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(CourseService.API_ENDPOINT + '/courses');
  }

  public getAllTeachers(): Observable<string[]> {
    return this.http.get<string[]>(CourseService.API_ENDPOINT + '/teachers');
  }

  public getAllLevels(): Observable<string[]> {
    return this.http.get<string[]>(CourseService.API_ENDPOINT + '/levels');
  }

  public createCourse(course: Course): Observable<any> {
    return this.http.post(CourseService.API_ENDPOINT + '/courses', course);
  }
}
