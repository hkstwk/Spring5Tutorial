package nl.kolvoort.udemy.spring5.config;

import nl.kolvoort.udemy.spring5.GuessCount;
import nl.kolvoort.udemy.spring5.MaxNumber;
import nl.kolvoort.udemy.spring5.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // fields
    @Value("${game.minNumber:50}")
    private int minNumber;

    @Value("${game.maxNumber:75}")
    private int maxNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    // bean methods
    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }

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
