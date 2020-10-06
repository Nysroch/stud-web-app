package hr.tvz.sekula.studapp.student;

import hr.tvz.sekula.studapp.course.Course;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "jmbag")
    private String jmbag;

    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;

    @Column(name = "ects")
    private Integer numberOfECTS;

    @ManyToMany(targetEntity = Course.class)
    @JoinTable(
            name = "student_course",
            joinColumns = { @JoinColumn(name = "student_id")},
            inverseJoinColumns = { @JoinColumn(name = "course_id")}
    )
    private List<Course> courses;

    public Student() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return dateOfBirth;
    }

    public String getJMBAG() {
        return jmbag;
    }

    public Integer getECTS() {
        return numberOfECTS;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLastName(String surname) {
        this.lastName = surname;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.dateOfBirth = birthDate;
    }

    public void setJMBAG(String JMBAG) {
        this.jmbag = JMBAG;
    }

    public void setECTS(Integer ECTS) {
        this.numberOfECTS = ECTS;
    }
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
