package de.telran.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    @Nullable Long studentId;
    String firstName;
    String lastName;
    @Nullable Long courseId;
}
