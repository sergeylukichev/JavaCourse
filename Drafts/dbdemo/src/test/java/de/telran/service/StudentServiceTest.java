package de.telran.service;

import de.telran.dto.School;
import de.telran.dto.StudentsByCourse;
import de.telran.repository.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class StudentServiceTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public StudentService employeeService() {
            return new StudentService();
        }
    }

    @Autowired
    StudentService service;

    @MockBean
    StudentRepository repo;

    @Test
    public void testGetSchoolInfo() {
        when(repo.getStudentsByCourseId())
                .thenReturn(createStudentsByCourse());

        School schoolInfo = service.getSchoolInfo();

        assertNotNull(schoolInfo);
    }

    private List<StudentsByCourse> createStudentsByCourse() {
        StudentsByCourse s1 = new StudentsByCourse("Java", "Ivan", "Petrov");
        StudentsByCourse s2 = new StudentsByCourse("QA", "Piotr", "Ivanov");
        return Arrays.asList(s1, s2);
    }

}
