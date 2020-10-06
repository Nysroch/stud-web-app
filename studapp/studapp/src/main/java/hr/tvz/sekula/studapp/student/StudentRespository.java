package hr.tvz.sekula.studapp.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRespository extends JpaRepository<Student, Integer> {


    Optional<Student> findStudentByjmbag(String JMBAG);


    void deleteStudentByjmbag(String jmbag);

    List<Student> findStudentsByNumberOfECTSBetween(Integer min, Integer max);

    List<Student> findStudentsByCourses(Integer id);
}
