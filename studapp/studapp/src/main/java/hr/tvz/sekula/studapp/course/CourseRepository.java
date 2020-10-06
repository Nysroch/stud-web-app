package hr.tvz.sekula.studapp.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findAll();

    @Query(value = "Select c.* from courses c " +
            "INNER JOIN student_course sc ON c.id = sc.course_id " +
            "INNER JOIN students s ON s.id = sc.student_id " +
            "WHERE s.jmbag = :jmbag", nativeQuery = true)

    List<Course> findByStudentJMBAG(final String jmbag);

    List<Course> findCourseById(final Integer id);

    List<Course> findCourseByNumberOfECTS(final Integer ects);

}
