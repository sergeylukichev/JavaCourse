package de.telran.model;

public interface GuessSource {
    public int guess() throws Exception;
    public void setGuessedNumber(Integer number);
}
