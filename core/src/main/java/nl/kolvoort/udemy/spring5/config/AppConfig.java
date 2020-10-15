package nl.kolvoort.udemy.spring5.config;

import nl.kolvoort.udemy.spring5.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "nl.kolvoort.udemy.spring5")
public class AppConfig {

    @Bean
    public Game game(){
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator(){
        return new MessageGeneratorImpl();
    }


}
