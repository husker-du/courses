import { Injectable } from '@angular/core';
import { BehaviorSubject } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private fileName = new BehaviorSubject('');

  public currentFileName = this.fileName.asObservable();

  constructor() { }

  public changeFileName(fileName: string) {
    this.fileName.next(fileName);
  }
}
