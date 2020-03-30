package de.telran.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
public class StudentsByCourse {
    private String title;
    private String firstName;
    private String lastName;
}
