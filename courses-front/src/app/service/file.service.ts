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
    return this.http.get<SubjectFile>(FileService.API_ENDPOINT + "/files/" + idFile);
  }


  public b64toBlob(b64Data, contentType='', sliceSize=512): Blob {
    const byteCharacters = atob(b64Data);
    const byteArrays = [];

    for (let offset = 0; offset < byteCharacters.length; offset += sliceSize) {
      const slice = byteCharacters.slice(offset, offset + sliceSize);

      const byteNumbers = new Array(slice.length);
      for (let i = 0; i < slice.length; i++) {
        byteNumbers[i] = slice.charCodeAt(i);
      }

      const byteArray = new Uint8Array(byteNumbers);
      byteArrays.push(byteArray);
    }

    const blob = new Blob(byteArrays, {type: contentType});
    return blob;
  }
}
