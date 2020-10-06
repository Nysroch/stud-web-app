package hr.tvz.sekula.studapp.student;

public class StudentDTO {


    private final String jmbag;
    private final Integer numberOfECTS;
    private final boolean tuitionShouldBePaid;
    private final String firstName;
    private final String lastName;

    public StudentDTO(String firstName, String lastName, String JMBAG, Integer numberOfECTS, boolean paysTuition) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbag = JMBAG;
        this.numberOfECTS = numberOfECTS;
        this.tuitionShouldBePaid = paysTuition;
    }

    public String getFirst_name() {
        return firstName;
    }

    public String getLast_name() {
        return lastName;
    }

    public String getJmbag() {
        return jmbag;
    }

    public Integer getNumberOfECTS() {
        return numberOfECTS;
    }

    public boolean isTuitionShouldBePaid() {
        return tuitionShouldBePaid;
    }

}
