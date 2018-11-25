package com.telran.project.tracker;

import com.telran.project.tracker.model.entity.User;
import com.telran.project.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = User.builder()
        .username("johnd")
        .password("123456")
        .firstName("John")
        .lastName("Dale")
        .build();

        userRepository.save(user);
    }
}
