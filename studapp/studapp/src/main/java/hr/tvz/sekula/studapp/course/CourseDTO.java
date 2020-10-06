package hr.tvz.sekula.studapp.course;

public class CourseDTO {
    private String name;
    private Integer numberOfECTS;


    public CourseDTO(String name, Integer ects) {
        this.name = name;
        this.numberOfECTS = ects;
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
