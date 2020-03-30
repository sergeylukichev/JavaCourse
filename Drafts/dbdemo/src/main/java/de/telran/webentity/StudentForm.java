package de.telran.webentity;

import de.telran.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentForm {
    String firstName;
    String lastName;
    Long course;
}
