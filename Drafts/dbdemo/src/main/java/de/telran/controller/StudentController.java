package de.telran.controller;

import de.telran.dto.School;
import de.telran.entity.Student;
import de.telran.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/api/students")
    List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @PostMapping("/api/students")
    Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @PutMapping("/api/students")
    Student assignStudentToCourse(@RequestBody Student student) {
        service.assignStudentToCourse(student);
        return service.getStudentById(student.getStudentId());
    }

    @GetMapping("/api/school")
    School getSchoolInfo() {
        return service.getSchoolInfo();
    }
}
