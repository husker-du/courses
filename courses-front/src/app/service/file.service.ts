import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest } from "@angular/common/http";
import { Observable } from "rxjs";
import { SubjectFile } from "../model/subject-file";

@Injectable({
  providedIn: 'root'
})
export class FileService {
  private static readonly API_ENDPOINT: string = 'http://localhost:8001/courses-catalogue/api/v1';

  constructor(
    private http: HttpClient
  ) { }

  public uploadFile(file: File): Observable<HttpEvent<{}>> {
    const data: FormData = new FormData();
    data.append('file', file);
    const newRequest = new HttpRequest('POST',
      FileService.API_ENDPOINT + '/files', data,
      {
        reportProgress: true,
        responseType: 'text'
      });
    return this.http.request(newRequest);
  }


  public downloadFile(idFile: number): Observable<SubjectFile> {
    return this.http.get(FileService.API_ENDPOINT + "/files/" + idFile);
  }

}
