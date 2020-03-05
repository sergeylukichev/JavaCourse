package de.telran.repository;

import de.telran.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Student s SET s.courseId = :courseId WHERE s.studentId = :studentId")
    int assignStudentToCourse(@Param("studentId") long studentId, @Param("courseId") long courseId);
}
