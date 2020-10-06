package hr.tvz.sekula.studapp.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class StudentServiceImpl implements StudentService {

    private static final int TUITION_YEAR_REQUIREMENT = 26;

    private final StudentRespository studentRespository;

    public StudentServiceImpl(StudentRespository studentRespository){
        this.studentRespository = studentRespository;
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRespository.findAll().stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    @Override
    public StudentDTO findStudentByJMBAG(final String JMBAG) {
        return studentRespository.findStudentByjmbag(JMBAG).map(this::mapStudentToDTO).orElse(null);
    }
    private StudentDTO mapStudentToDTO(final Student student){
        return new StudentDTO(student.getFirstName(),student.getLastName(), student.getJMBAG(), student.getECTS(),
                shouldTuitionBePayed(student.getBirthDate()));
    }
    private boolean shouldTuitionBePayed(LocalDate birthDate){
        return birthDate.plusYears(TUITION_YEAR_REQUIREMENT).isBefore(LocalDate.now());
    }


    @Override
    public Optional<StudentDTO> save(StudentCommand command) {
        Student stud = new Student();
        stud.setFirstName(command.getFirstName());
        stud.setLastName(command.getLastName());
        stud.setBirthDate(command.getBirthDate());
        stud.setECTS(command.getECTS());
        stud.setJMBAG(command.getJMBAG());

        studentRespository.save(stud);

        return Optional.of(mapStudentToDTO(stud));


    }



    @Override
    public void deleteByJMBAG(String jmbag) {
        studentRespository.deleteStudentByjmbag(jmbag);
    }

    @Override
    public List<Student> findStudentsByEcts(Integer min, Integer max){
        return studentRespository.findStudentsByNumberOfECTSBetween(min, max);
    }

    @Override
    public List<StudentDTO> findStudentsByCourse(Integer id) {
        return studentRespository.findStudentsByCourses(id).stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }



}
