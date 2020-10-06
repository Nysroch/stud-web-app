package hr.tvz.sekula.studapp.student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDTO> findAll();
    StudentDTO findStudentByJMBAG(String JMBAG);


    Optional<StudentDTO> save(StudentCommand command);


    void deleteByJMBAG(String jmbag);

    List<Student> findStudentsByEcts(Integer min, Integer max);

    List<StudentDTO> findStudentsByCourse(final Integer id);
}
