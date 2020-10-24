package nl.kolvoort.udemy.spring5.controller;


import lombok.extern.slf4j.Slf4j;
import nl.kolvoort.udemy.spring5.services.GameService;
import nl.kolvoort.udemy.spring5.util.AttributeNames;
import nl.kolvoort.udemy.spring5.util.GameMapping;
import nl.kolvoort.udemy.spring5.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class GameController {

    // fields
    private final GameService gameService;

    // Constructors
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // request methods
    @RequestMapping(GameMapping.PLAY)
    public String play(Model model){
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        log.info("model = {}", model);

        if (gameService.isGameOver()){
            return ViewNames.GAME_OVER;
        }

        return ViewNames.PLAY;
    }

    @PostMapping(GameMapping.PLAY)
    public String procesMessage(@RequestParam int guess){
        log.info("guess = {}", guess);
        gameService.checkGuess(guess);
        return GameMapping.REDIRECT_PLAY;
    }
}
