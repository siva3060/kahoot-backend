package com.penchala.yegu.game.controller;

import com.penchala.yegu.game.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService;

// curl http://localhost:8080/game/create?userId=234
    @GetMapping(path = "/create")
    public Integer generateGamePin(@RequestParam int userId){
        Integer gamePin;
        gamePin = gameService.createNewGame(userId);
        log.info("A new game request is created with game pin"+gamePin+"By User"+userId);
        return gamePin;
    }

// curl http://localhost:8080/game/join/234
    @GetMapping(path = "/join/{gameId}")
    public String gameExist(@PathVariable("gameId") int gameId){
        log.info("Looking up for game to join using game pin"+ gameId);
        if(gameService.findGameById(gameId)){
            return "Game  Exist";
        }
        return "Game Does't Exit";
    }
}
