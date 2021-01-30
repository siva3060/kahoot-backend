package com.penchala.yegu.game.controller;

import com.penchala.yegu.game.model.PlayStat;
import com.penchala.yegu.game.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/game")
@CrossOrigin(origins="*")
public class GameController {

    @Autowired
    GameService gameService;

// curl http://localhost:8080/game/create?userId=234
    @GetMapping(path = "/create")
    public Integer generateGamePin(@RequestParam int userId){
        int gamePin =  gameService.createNewGame(userId);
        log.info("A new game request is created by user "+userId+" with game pin "+gamePin);
        return gamePin;
    }

// curl http://localhost:8080/game/join/234/123
    @GetMapping(path = "/join/{gameId}/{playerId}")
    public ResponseEntity<String> gameExist(@PathVariable("gameId") int gameId,
                                            @PathVariable("playerId") int playerId){
        if(gameService.joinGame(gameId,playerId)){
            log.info("Player with ID "+playerId+" Has joined the game with game Id"+gameId);
            return new ResponseEntity<>("Game  Exist",HttpStatus.OK);
        }
        log.info("Game with game Id"+gameId+"does not exist");
        return new ResponseEntity<>("Game With Pin Doesn't Exit",HttpStatus.NO_CONTENT);
    }

    // curl http://localhost:8080/game/lobby/players/2347
    @GetMapping("/lobby/players/{gamePin}")
    public List<Integer> getLobby(@PathVariable int gamePin){
        log.info("Looking for player in lobby with game pin "+gamePin);
        return gameService.getLobbyPlayers(gamePin);
    }

    // curl http://localhost:8080/game/save/playstat
    @PostMapping("/save/playstat")
    public void savePlayStat(PlayStat playStat) {
         gameService.savePlayerStatistics(playStat);
    }

    // curl http://localhost:8080/game/gameStat
    @GetMapping("/gamestat")
    public void getGameStat(@RequestParam(value = "gameId") int gameId,
                            @RequestParam(value = "userId") int playerId){
        gameService.getPlayAggregrateStat(gameId,playerId);
    }

    // curl http://localhost:8080/game/playAggStat
    @GetMapping("/playAggStat")
    public void getAggregratePlayStat(@RequestParam(value = "gameId") int gameId,
                                      @RequestParam(value = "userId") int playerId){
        gameService.getPlayAggregrateStat(gameId,playerId);
    }
}
