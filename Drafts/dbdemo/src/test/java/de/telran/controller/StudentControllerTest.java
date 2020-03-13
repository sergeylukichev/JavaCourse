package de.telran.controller;

import de.telran.dto.Course;
import de.telran.dto.School;
import de.telran.entity.Student;
import de.telran.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService service;

    @Test
    public void testGetAllStudents() throws Exception {
        when(service.getAllStudents())
                .thenReturn(createListOfStudents());

        mvc.perform(get("/api/students")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())//good for simple debugging
                .andExpect(jsonPath("$[0].studentId").value("0"))
                .andExpect(jsonPath("$[0].firstName").value("Ivan"))
                .andExpect(jsonPath("$[0].lastName").value("Petrov"))
                .andExpect(jsonPath("$[0].courseId").value("1"))
                .andExpect(jsonPath("$[1].studentId").value("1"))
                .andExpect(jsonPath("$[1].firstName").value("Piotr"))
                .andExpect(jsonPath("$[1].lastName").value("Ivanov"))
                .andExpect(jsonPath("$[1].courseId").value("2"));

    }

    @Test
    public void testCreateNewStudent() throws Exception {
        Student studentEntity = new Student(null, "ivan", "petrov", null);
        Student savedStudentEntity = new Student(1L, "ivan", "petrov", null);
        when(service.createStudent(studentEntity)).thenReturn(savedStudentEntity);

        mvc.perform(post("/api/students")
                .content("{\"firstName\": \"ivan\",\"lastName\":\"petrov\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        verify(service, times(1)).createStudent(studentEntity);

    }

//    @Test
//    public void testGetSchoolInfo() throws Exception {
//        when(service.getSchoolInfo()).thenReturn(getSchoolData());
//        mvc.perform(get("/api/school")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(print())//good for simple debugging
//                .andExpect(jsonPath("$.courses").isArray())
//                .andExpect(jsonPath("$.courses[0].title").value("Java"))
//                .andExpect(jsonPath("$.courses[0].students[0].firstName").value("Ivan"))
//                .andExpect(jsonPath("$.courses[0].students[0].lastName").value("Petrov"))
//                .andExpect(jsonPath("$.courses[0].students[1].firstName").value("Piotr"))
//                .andExpect(jsonPath("$.courses[0].students[1].lastName").value("Ivanov"));
//    }

//    private School getSchoolData() {
//        de.telran.dto.Student s1 = new de.telran.dto.Student("Ivan", "Petrov");
//        de.telran.dto.Student s2 = new de.telran.dto.Student("Piotr", "Ivanov");
//        Course c1 = new Course("Java", Arrays.asList(s1, s2));
//
//        de.telran.dto.Student s3 = new de.telran.dto.Student("Sergey", "Lukichev");
//        Course c2 = new Course("QA", Arrays.asList(s3));
//
//        return new School(Arrays.asList(c1, c2));
//    }
//
//
//
    private List<Student> createListOfStudents(){
        Student student1 = new Student();
        student1.setStudentId(0L);
        student1.setFirstName("Ivan");
        student1.setLastName("Petrov");
        student1.setCourseId(1L);

        Student student2 = new Student();
        student2.setStudentId(1L);
        student2.setFirstName("Piotr");
        student2.setLastName("Ivanov");
        student2.setCourseId(2L);

        return Arrays.asList(student1, student2);
    }

}
