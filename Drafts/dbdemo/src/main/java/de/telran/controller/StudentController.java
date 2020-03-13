package de.telran.controller;

import de.telran.dto.StudentDTO;
import de.telran.entity.Student;
import de.telran.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private StudentService service;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/api/students")
    List<StudentDTO> getAllStudents() {
        return service.getAllStudents()
                .stream()
                .map(s -> modelMapper.map(s, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/api/students")
    StudentDTO createStudent(@RequestBody StudentDTO student) {
        System.out.println(student);
        Student studentEntity = modelMapper.map(student, Student.class);
        System.out.println(studentEntity);
        return modelMapper.map(service.createStudent(studentEntity), StudentDTO.class);
    }

//    @PutMapping("/api/students")
//    Student assignStudentToCourse(@RequestBody Student student) {
//        service.assignStudentToCourse(student);
//        return service.getStudentById(student.getStudentId());
//    }

//    @GetMapping("/api/school")
//    School getSchoolInfo() {
//        return service.getSchoolInfo();
//    }
}
