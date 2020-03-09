package de.telran.service;

import de.telran.dto.Course;
import de.telran.dto.School;
import de.telran.entity.Student;
import de.telran.dto.StudentsByCourse;
import de.telran.repository.StudentRepository;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class StudentService {

    @Autowired
    private StudentRepository respository;

    public Student createStudent(Student student) {
        return respository.save(student);
    }

    public List<Student> getAllStudents() {
        return respository.findAll();
    }

    public Student getStudentById(Long studentId) {
        return respository.getOne(studentId);
    }

    public int assignStudentToCourse(Student student) {
        return respository.assignStudentToCourse(student.getStudentId(), student.getCourseId());
    }

    public School getSchoolInfo() {
        List<StudentsByCourse> studentsByCourse = respository.getStudentsByCourseId();
        System.out.println(studentsByCourse);

        List<Course> courses = new ArrayList<>();

        Map<String, List<StudentsByCourse>> collect = studentsByCourse
                .stream()
                .collect(Collectors.groupingBy(StudentsByCourse::getTitle));

        collect.forEach((k, v) ->
                courses.add(new Course(k, v.stream().map(s -> new de.telran.dto.Student(s.getFirstName(), s.getLastName()))
                        .collect(toList()))));

        return new School(courses);
    }
}
