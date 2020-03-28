import { Teacher } from "../model/teacher";

export class Course {
  id: number;
  title: string;
  level: string;
  hours: number;
  active: number;
  idTeacher: number;
  teacher: Teacher;
  idFile: number;
}
