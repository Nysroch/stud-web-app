package hr.tvz.sekula.studapp.course;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }

    private CourseDTO mapCourseToDTO(final Course course){
        return new CourseDTO(course.getName(), course.getEcts());
    }

    @Override
    public List<CourseDTO> findByStudentJMBAG(final String jmbag) {
        return courseRepository.findByStudentJMBAG(jmbag).stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }
    @Override
    public List<CourseDTO> findCourseById(final Integer id) {
        return courseRepository.findCourseById(id).stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findCourseByEcts(final Integer ects){
        return courseRepository.findCourseByNumberOfECTS(ects).stream().map(this::mapCourseToDTO).collect(Collectors.toList());

    }
}
