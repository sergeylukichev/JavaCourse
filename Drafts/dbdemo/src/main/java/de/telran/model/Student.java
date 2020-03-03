package de.telran.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long studentId;
    private String firstName;
    private String lastName;
    private @Nullable Long courseId;
}
