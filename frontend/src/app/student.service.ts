import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Student } from './student';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Course } from './course';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private studentsUrl = 'http://localhost:8080/student';
  private courseUrl = 'http://localhost:8080/course';



  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'})
  };

  constructor(
    private http: HttpClient
  ) { }

  getStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(this.studentsUrl)
    .pipe(
      tap(_ => console.log('fetched students')),
      catchError(this.handleError<Student[]>('getStudents', [])));
  }
  private handleError<T>(operation = 'operation', result?:T){
    return (error: any): Observable<T> => {
      console.error(operation);
      console.error(error);
      return of(result as T);
    }
  }
  addStudent(student: Student): Observable<Student>{
    return this.http.post<Student>(this.studentsUrl, student, this.httpOptions).pipe(
      tap((newStudent: Student) => console.log(`added student w/ JMBAG=${newStudent.jmbag}`)),
      catchError(this.handleError<Student>('addStudent'))
    );
  }
  updateStudent(student: Student): Observable<any> {
    const url = `${this.studentsUrl}/${student.jmbag}`;
    return this.http.put(url, student, this.httpOptions).pipe(
      tap(_ => console.log(`updated student JMBAG = ${student.jmbag}`)),
      catchError(this.handleError<any>('updateStudent'))
    );
  }
  deleteStudent(jmbag: string){
    
    const url = `${this.studentsUrl}/${jmbag}`;
    this.http.delete(url);

  }
  coursesOfStudent(jmbag: string): Observable<Course[]> {

    const url = `${this.courseUrl}/${jmbag}`;

    return this.http.get<Course[]>(url, this.httpOptions);



  }
}
