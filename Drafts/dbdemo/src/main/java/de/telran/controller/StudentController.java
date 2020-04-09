package de.telran.controller;

import de.telran.dto.StudentDTO;
import de.telran.entity.Student;
import de.telran.exception.StudentNotFoundException;
import de.telran.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private StudentService service;

    private ModelMapper modelMapper;

    @Autowired
    public StudentController(StudentService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api/students")
    List<StudentDTO> getAllStudents() {
        return service.getAllStudents()
                .stream()
                .map(s -> modelMapper.map(s, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/api/students/{student_id}")
    StudentDTO getStudentById(@PathVariable("student_id") long studentId) throws StudentNotFoundException {
        return modelMapper.map(service.getStudentById(studentId), StudentDTO.class);
    }

    @PostMapping("/api/students")
    StudentDTO createStudent(@RequestBody StudentDTO student) {

        Student st = new Student();
        st.setStudentId(student.getStudentId());
        st.setFirstName(student.getFirstName());
        Student studentEntity = modelMapper.map(student, Student.class);
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
