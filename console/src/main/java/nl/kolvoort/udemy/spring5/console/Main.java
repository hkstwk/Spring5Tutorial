package nl.kolvoort.udemy.spring5.console;

import nl.kolvoort.udemy.spring5.config.AppConfig;
import nl.kolvoort.udemy.spring5.Game;
import nl.kolvoort.udemy.spring5.MessageGenerator;
import nl.kolvoort.udemy.spring5.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        // Create context (container)
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        // get numberGenerator bean from context (container)
        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);

        // Call method next() to get a random number
        int number = numberGenerator.next();

        // Log generated number
        log.info("the number is {}", number);

        // get game bean from context (container)
        Game game = context.getBean(Game.class);

        // get MessageGenerator bean from context (container)
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        // Call methods of Message Generator and log the results
        log.info("result of getMainMessage() is {}", messageGenerator.getMainMessage());
        log.info("result of getResultMessage() is {}", messageGenerator.getResultMessage());

        // Close context (container)
        context.close();
    }
}
