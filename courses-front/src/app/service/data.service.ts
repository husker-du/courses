import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private fileName: BehaviorSubject<string> = new BehaviorSubject<string>('');
  private fileData: BehaviorSubject<Blob> = new BehaviorSubject<Blob>(null);

  public currentFileName: Observable<string> = this.fileName.asObservable();
  public currentFileData: Observable<Blob> = this.fileData.asObservable();

  constructor() { }

  public changeFileName(fileName: string): void {
    this.fileName.next(fileName);
  }

  public changeFileData(fileData: Blob): void {
    this.fileData.next(fileData);
  }
}
