package de.telran.service;

import de.telran.dto.Course;
import de.telran.dto.School;
import de.telran.dto.StudentDTO;
import de.telran.entity.Student;
import de.telran.dto.StudentsByCourse;
import de.telran.exception.StudentNotFoundException;
import de.telran.repository.CourseRepository;
import de.telran.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class StudentService {

    @Autowired
    private StudentRepository respository;

    @Autowired
    CourseRepository courseRepository;

    public List<de.telran.entity.Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Student createStudent(Student student) {
        Student savedStudent = respository.save(student);
        return savedStudent;
    }

    public List<de.telran.entity.Student> getAllStudents() {
        return respository.findAll();
    }

    public Student getStudentById(Long studentId) throws StudentNotFoundException {
        Optional<Student> studentByStudentId = respository.findById(studentId);

        return studentByStudentId.orElseThrow(() -> new StudentNotFoundException("Student not found "+studentId));
    }

    public int assignStudentToCourse(Student student) {
        return respository.assignStudentToCourse(student.getStudentId(), student.getCourseId());
    }
//
    public School getSchoolInfo() {
        List<StudentsByCourse> studentsByCourse = respository
                .getStudentsByCourseId();

        List<Course> courses = new ArrayList<>();

        Map<String, List<StudentsByCourse>> collect = studentsByCourse
                .stream()
                .collect(Collectors.groupingBy(StudentsByCourse::getTitle));

        collect.forEach((k, v) ->
                courses.add(new Course(k, v.stream().map(s -> new StudentDTO(null, s.getFirstName(), s.getLastName(), null))
                        .collect(toList()))));

        return new School(courses);
    }
}
