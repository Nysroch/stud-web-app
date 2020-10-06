import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  students:Student[];
  selectedStudent: Student;

  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    this.getStudents();
  }
  getStudents(): void {
    this.studentService.getStudents().subscribe(students => this.students = students);
  }
  onSelect(student: Student): void {
    this.selectedStudent = student;
  }
  add(firstName: string, lastName: string, jmbag: string, ects: number): void {
    firstName= firstName.trim();
    lastName= lastName.trim();
    jmbag= jmbag.trim();
    
    if(!firstName || !lastName || !jmbag || !ects) {
      return;
    }
    const dateOfBirth = "1999-12-12";

    this.studentService.addStudent({ firstName, lastName, jmbag, ects, dateOfBirth } as Student)
    .subscribe(student => {
      this.students.push(student);
    });
    console.log(this.students);
  }
  delete(jmbag: string){
    this.studentService.deleteStudent(jmbag);

    this.students = this.students.filter(stud => stud.jmbag !== jmbag);
      
  }
}
