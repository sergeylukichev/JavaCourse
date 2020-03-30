package de.telran.repository;

import de.telran.entity.Student;
import de.telran.dto.StudentsByCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Student s SET s.courseId = :courseId WHERE s.studentId = :studentId")
    int assignStudentToCourse(@Param("studentId") long studentId, @Param("courseId") long courseId);

    @Query("select new de.telran.dto.StudentsByCourse(c.title, s.firstName, s.lastName) from Course as c join Student s on s.courseId = c.courseId")
    List<StudentsByCourse> getStudentsByCourseId();

    Student findStudentByStudentId(Long stidentId);
}
