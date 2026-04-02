package com.example.securitytesting;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getStudentByCourse(String course) {
        return studentRepository.findByCourse(course);
    }

    public String getWelcomeMessage() {
        return "Welcome to the Student Service!";
    }


}
