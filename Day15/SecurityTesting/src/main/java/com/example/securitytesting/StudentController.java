package com.example.securitytesting;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService=studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/course/{course}")
    public List<Student> getStudentByCourse(@PathVariable String course) {
        return studentService.getStudentByCourse(course);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String getAdminMessage() {
        return "This is an admin-only endpoint.";
    }

}
