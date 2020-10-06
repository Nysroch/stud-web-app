import { Component, OnInit, Input } from '@angular/core';
import { Student } from '../student';
import { ActivatedRoute } from '@angular/router';
import { StudentService } from '../student.service';
import { map } from 'rxjs/operators';
import { Subscription, Observable } from 'rxjs';
import { Course } from '../course';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

  @Input() jmbag: string;
  student: Student;
  studentService: StudentService;
  sub : Subscription;
  courses: Observable<Course[]>;

  constructor(
    private route: ActivatedRoute, studentService : StudentService) {
      this.studentService = studentService;
   }

  

  ngOnInit(): void {
      this.sub = this.route.params.subscribe(params => {
      this.jmbag = params['jmbag'];

      this.studentService.getStudents().pipe(
      map(student => student.find(e => e.jmbag === this.jmbag)))
      .subscribe(b => this.student=b);
      })
      console.log(this.student);

      this.courses = this.studentService.coursesOfStudent(this.jmbag)
    }}
    
