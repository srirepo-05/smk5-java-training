package com.example.securitytesting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
@Import(SecurityConfig.class)
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private StudentService studentService;

    @Test
    void testGetAllStudents() throws Exception {
        // Implement test for GET /students
        when(studentService.getAllStudents()).thenReturn(List.of(
                new Student(1L, "John Doe", "Computer Science")));
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[0].course").value("Computer Science"));

    }

}
