package de.telran.game;

import org.springframework.stereotype.Component;

@Component
public class ConsoleOutput implements ResultOutput {

    @Override
    public void output(String result) {
        System.out.println(result);
    }
}
