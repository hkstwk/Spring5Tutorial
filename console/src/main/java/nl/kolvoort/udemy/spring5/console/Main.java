package nl.kolvoort.udemy.spring5.console;

import lombok.extern.slf4j.Slf4j;
import nl.kolvoort.udemy.spring5.config.GameConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        // Create context (container)
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(GameConfig.class);

        // Close context (container)
        context.close();
    }
}
