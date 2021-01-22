package com.penchala.yegu.game.controller;

import com.penchala.yegu.game.model.PlayStat;
import com.penchala.yegu.game.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<String> gameExist(@PathVariable("gameId") int gameId,@RequestParam int playerId){
        log.info("Looking up for game to join using game pin"+ gameId);
        if(gameService.joinGame(gameId,playerId)){
            log.info("Player with ID "+playerId+"Has joined the game with game Id"+gameId);
            return new ResponseEntity<>("Game  Exist",HttpStatus.OK);
        }
        log.info("Game with game Id"+gameId+"does not exist");
        return new ResponseEntity<>("Game With Pin Does't Exit",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/lobby/{gamePin}")
    public List<Integer> getLobby(int gamePin){
            return gameService.getLobbyPlayers(gamePin);
    }

    @PostMapping("/save/playstat")
    public void savePlayStat(PlayStat playStat) {
         gameService.savePlayerStatistics(playStat);
    }

    @GetMapping("/gamestat")
    public void getGameStat(@RequestParam(value = "gameId") int gameId,
                            @RequestParam(value = "userId") int playerId){
        gameService.getPlayAggregrateStat(gameId,playerId);
    }

    @GetMapping("/playAggStat")
    public void getAggregratePlayStat(@RequestParam(value = "gameId") int gameId,
                                      @RequestParam(value = "userId") int playerId){
        gameService.getPlayAggregrateStat(gameId,playerId);
    }
}
