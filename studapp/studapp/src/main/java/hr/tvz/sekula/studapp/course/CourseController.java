package hr.tvz.sekula.studapp.course;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<List<CourseDTO>> getAllCourses(){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findAll());
    }

    @GetMapping(params = "jmbag")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<List<CourseDTO>> getCoursesByJMBAG(@RequestParam final String JMBAG){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findByStudentJMBAG(JMBAG));
    }
    @GetMapping(params = "id")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<List<CourseDTO>> getCourseByID(@RequestParam final Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findCourseById(id));
    }
    @GetMapping(params = "ects")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<List<CourseDTO>> getCourseByEcts(@RequestParam final Integer ects){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findCourseByEcts(ects));
    }
}
