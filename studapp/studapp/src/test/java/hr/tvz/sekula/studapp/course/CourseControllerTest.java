package hr.tvz.sekula.studapp.course;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    void getAllCourses() throws Exception{
        this.mockMvc.perform(get("/course")
                .with(user("admin")
                .password("mama")
                .roles("ADMIN"))
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    void getCoursesByJMBAG() throws Exception{
        this.mockMvc.perform(get("/course?JMBAG=0321586491")
                .with(user("admin")
                .password("mama")
                .roles("ADMIN"))
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    void getCourseByID() throws Exception{
        this.mockMvc.perform(get("/course?id=1")
                .with(user("admin")
                .password("mama")
                .roles("ADMIN"))
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getCourseByEcts() throws Exception{
        this.mockMvc.perform(get("/course?ects=6")
                .with(user("admin")
                .password("mama")
                .roles("ADMIN"))
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}