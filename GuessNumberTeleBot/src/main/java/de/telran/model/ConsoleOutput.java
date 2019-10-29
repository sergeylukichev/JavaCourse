package de.telran.model;

public class ConsoleOutput implements ResultOutput {

    @Override
    public void output(String result) {
        System.out.println(result);
    }

    @Override
    public String getOutput() throws Exception {
        throw new Exception("No supported for console");
    }
}
