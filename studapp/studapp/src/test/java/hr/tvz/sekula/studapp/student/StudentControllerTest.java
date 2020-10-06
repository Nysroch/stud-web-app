package hr.tvz.sekula.studapp.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllStudents() throws Exception{
        this.mockMvc.perform(get("/student")
                .with(user("admin")
                .password("mama")
                .roles("ADMIN"))
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getStudentByJMBAG() throws Exception{
        this.mockMvc.perform(get("/student/0321586491")
                .with(user("admin")
                .password("mama")
                .roles("ADMIN"))
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void save() throws Exception{

        String theString = "{\n" +
                " \"firstName\": \"Dino\",\n " +
                " \"lastName\": \"Sehic\",\n " +
                " \"jmbag\": 1098765432,\n " +
                " \"numberOfECTS\": 231,\n " +
                " \"dateOfBirth\": \"1980-03-12\"\n " +
                "}";



        this.mockMvc.perform(post("/student")
                .with(user("admin")
                .password("mama")
                .roles("ADMIN"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(theString)
                .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.jmbag").value("1098765432"));

    }

    @Test
    void saveConflict() throws Exception{

        String theString = "{\n" +
                " \"firstName\": \"Dino\",\n " +
                " \"lastName\": \"Sehic\",\n " +
                " \"jmbag\": 10987654320,\n " +
                " \"numberOfECTS\": 231,\n " +
                " \"dateOfBirth\": \"1980-03-12\"\n " +
                "}";




        this.mockMvc.perform(post("/student")
                .with(user("admin")
                        .password("mama")
                        .roles("ADMIN"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(theString)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isBadRequest());

    }
}