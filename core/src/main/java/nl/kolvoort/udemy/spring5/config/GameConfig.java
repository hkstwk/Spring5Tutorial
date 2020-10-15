package nl.kolvoort.udemy.spring5.config;

import nl.kolvoort.udemy.spring5.GuessCount;
import nl.kolvoort.udemy.spring5.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    // fields
    private int maxNumber = 25;

    private int guessCount = 8;

    // bean methods
    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }

}
