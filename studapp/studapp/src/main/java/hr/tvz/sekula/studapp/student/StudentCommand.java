package hr.tvz.sekula.studapp.student;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class StudentCommand {
    @JsonProperty("firstName")
    @NotBlank(message = "First name must not be empty")
    private String firstName;


    @JsonProperty("lastName")
    @NotBlank(message = "Surname must not be empty")
    private String lastName;


    @JsonProperty("jmbag")
    @NotBlank(message = "JMBAG must not be empty")
    @Pattern(message = "JMBAG must have 10 digits", regexp="[\\d]{10}")
    private String jmbag;


    @JsonProperty("dateOfBirth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Date of birth must be entered")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;


    @JsonProperty("numberOfECTS")
    @NotNull(message = "Number of ECTS must be entered")
    @PositiveOrZero(message = "Number of ECTS must be a positive integer")
    @Max(message = "Number of ECTS can not be higher then 480", value = 480)
    private Integer numberOfECTS;



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() { return lastName;  }

    public LocalDate getBirthDate() { return dateOfBirth; }

    public String getJMBAG() {
        return jmbag;
    }

    public Integer getECTS() {
        return numberOfECTS;
    }

}
