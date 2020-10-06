package hr.tvz.sekula.studapp.course;

import java.util.List;

public interface CourseService {
    List<CourseDTO> findAll();

    List<CourseDTO> findByStudentJMBAG(final String jmbag);

    List<CourseDTO> findCourseById(final Integer id);

    List<CourseDTO> findCourseByEcts(final Integer ects);
}
