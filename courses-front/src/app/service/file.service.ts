import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpRequest} from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FileService {
  private static readonly API_ENDPOINT: string = 'http://localhost:8001/courses-catalogue/api/v1/file';

  constructor(
    private http: HttpClient
  ) { }

  public uploadFile(file: File): Observable<HttpEvent<{}>> {
    const data: FormData = new FormData();
    data.append('file', file);
    const newRequest = new HttpRequest('POST',
      FileService.API_ENDPOINT + '/upload', data,
      {
        reportProgress: true,
        responseType: 'text'
      });
    return this.http.request(newRequest);
    //return this.http.post(FileService.API_ENDPOINT + '/upload', uploadData);
  }

}
