package nl.kolvoort.udemy.spring5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageGeneratorImpl implements MessageGenerator {

    // Constants
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    // Fields
    private final Game game;

    // init method
    @PostConstruct
    public void init() {
        log.debug("game is {}", game);
    }

    // constructors
    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    // public methods
    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()){
            return "You guessed it! The number was " + game.getNumber();
        } else if (game.isGameLost()){
            return "You lost! The number was " + game.getNumber();
        } else if (!game.isValidNumberRange()){
            return "Invalid number range. Try again!";
        } else if (game.getRemainingGuesses() == game.getGuessCount()){
            return "What is your first guess?";
        } else {
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()){
                direction = "Higher";
            }
            return direction + "! you have " + game.getRemainingGuesses() + " guesses left";
        }
    }
}
