package nl.kolvoort.udemy.spring5.services;

public interface GameService {

    boolean isGameOver();
    String getResultMessage();
    String getMainMessage();
    void checkGuess(int guess);
    void reset();
}
