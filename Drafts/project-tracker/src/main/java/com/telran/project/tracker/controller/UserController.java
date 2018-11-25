package com.telran.project.tracker.controller;

import com.telran.project.tracker.exception.AuthenticationException;
import com.telran.project.tracker.exception.PasswordsDoNotMatchException;
import com.telran.project.tracker.model.entity.User;
import com.telran.project.tracker.model.entity.UserSession;
import com.telran.project.tracker.model.web.LoginRequest;
import com.telran.project.tracker.model.web.LoginResponse;
import com.telran.project.tracker.model.web.RegistrationRequest;
import com.telran.project.tracker.repository.UserRepository;
import com.telran.project.tracker.repository.UserSessionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserSessionRepository userSessionRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public void register(@RequestBody RegistrationRequest request) {

        if (!request.getPassword().equals(request.getRepeatPassword())) {
            throw new PasswordsDoNotMatchException();
        }

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .password(request.getPassword())
                .build();

        userRepository.save(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {

        User user = userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (user == null) {
            log.warn("Incorrect username or password. Incoming parameters are: {} - {}", loginRequest.getUsername(), loginRequest.getPassword());
            throw new AuthenticationException("Username or password is incorrect");
        }

        UserSession userSession = UserSession.builder()
                .sessionId(UUID.randomUUID().toString())
                .user(user)
                .isValid(true)
                .build();

        userSessionRepository.save(userSession);
        return LoginResponse
                .builder()
                .token(userSession.getSessionId())
                .build();
    }

    @PutMapping("/logout")
    public void logout(@RequestHeader("Authorization") String header) {

        UserSession userSession = userSessionRepository.findBySessionIdAndIsValidTrue(header);
        userSession.setIsValid(false);
        userSessionRepository.save(userSession);
    }
}
