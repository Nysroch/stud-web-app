package hr.tvz.sekula.studapp.course;

import hr.tvz.sekula.studapp.student.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="courses")
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name="ects")
    private Integer numberOfECTS;

    @ManyToMany(targetEntity = Student.class, mappedBy = "courses")
    private List<Student> students;

    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEcts() {
        return numberOfECTS;
    }

    public void setEcts(Integer ects) {
        this.numberOfECTS = ects;
    }

}
