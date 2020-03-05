package de.telran.service;

import de.telran.model.Student;
import de.telran.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public void assignStudentToCourse(Student student) {
        repository.assignStudentToCourse(student.getStudentId(), student.getCourseId());
    }

    public Student getStudentById(Long id) {
        return repository.getOne(id);
    }
}
