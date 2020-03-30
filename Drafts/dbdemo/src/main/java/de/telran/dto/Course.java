package de.telran.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Course {
    String title;
    List<StudentDTO> students;
}
