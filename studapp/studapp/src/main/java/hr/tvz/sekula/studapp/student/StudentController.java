package hr.tvz.sekula.studapp.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    @Secured({"ROLE_USER", "ROLE_ADMIN", "ROLE_UPDATER"})
    public List<StudentDTO> getAllStudents(){
        System.out.println("nabavi sve studente");
        return studentService.findAll();
    }

    @GetMapping("/{JMBAG}")
    @Secured({"ROLE_USER", "ROLE_ADMIN", "ROLE_UPDATER"})
    public ResponseEntity<StudentDTO> getStudentByJMBAG(@PathVariable final String JMBAG) {
        StudentDTO stud = studentService.findStudentByJMBAG(JMBAG);
        if (stud == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(stud);

    }
    @PostMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody final StudentCommand command){
        return studentService.save(command)
                .map(
                        studentDTO -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(studentDTO))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }
     @PutMapping("/{JMBAG}")
     @Secured({"ROLE_ADMIN", "ROLE_UPDATER"})
    public ResponseEntity<StudentDTO> update(@PathVariable String JMBAG, @Valid @RequestBody final StudentCommand command){

        return studentService.save(command).map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());

     }

     @DeleteMapping("/{JMBAG}")
     @Secured("ROLE_ADMIN")
    public void delete(@PathVariable String JMBAG){
        studentService.deleteByJMBAG(JMBAG);
     }


}
