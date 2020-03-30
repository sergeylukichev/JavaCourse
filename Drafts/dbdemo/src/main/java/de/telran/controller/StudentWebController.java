package de.telran.controller;

import de.telran.entity.Student;
import de.telran.service.StudentService;
import de.telran.webentity.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentWebController {

    @Autowired
    StudentService service;

    @GetMapping("/hello")
    String sayHello(Model model) {
        model.addAttribute("greeting", " Thymleaf");
        return "index";
    }

    @GetMapping("/students")
    String getAllStudents(Model model) {
        model.addAttribute("studentForm", new StudentForm());
        model.addAttribute("courses", service.getAllCourses());
        model.addAttribute("students", service.getAllStudents());
        return "students";
    }

    @PostMapping("/addStudent")
    String addStudent(Model model, StudentForm studentForm) {
        Student student = new Student();
        student.setFirstName(studentForm.getFirstName());
        student.setLastName(studentForm.getLastName());
        student.setCourseId(studentForm.getCourse() == 0 ? null: studentForm.getCourse());
        service.createStudent(student);

        model.addAttribute("students", service.getAllStudents());

        return "students";
    }
}
