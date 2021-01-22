package com.penchala.yegu.game.service;

import com.penchala.yegu.game.model.Game.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Slf4j
@Service
public class GameService {

        List<Game> gameList = new ArrayList();

    public Integer createNewGame(int userId) {
        Game game = initaliseGame(userId);
        gameList.add(game);
        log.info("A game is added to the games Database");
        return game.getGamePin();
    }

    private Game initaliseGame(int userId){
        int gamePin = new Random().nextInt(9999);
        Date gameCreationDate = new Date();
        Game game = new Game(gamePin,userId,gameCreationDate);
        log.info("A game "+gamePin+" is created at"+gameCreationDate);
        return game;
    }

    public Boolean findGameById(int gameId) {
        //Stream<Game> resultGame = gameList.stream().filter((game -> game.getGamePin().equals(gameId)));
        for (Game game : gameList) {
            if(game.getGamePin().equals(gameId)){
                log.info("A game with Id "+gameId+" exit method returns true");
                return true;
            }
        }
        log.info("A game with Id "+gameId+" does not exit method returns false");
        return false;
    }
}

/* TODO :
*   1. Check for gamepin duplication
*   2. Create a game factory which returns unique game every time called for game
*   3. Convert collection into stream library
*   4. May be if possible convert the whole microservice into functional approach
* */
