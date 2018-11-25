package com.telran.project.tracker.model.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegistrationRequest {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String repeatPassword;
}
