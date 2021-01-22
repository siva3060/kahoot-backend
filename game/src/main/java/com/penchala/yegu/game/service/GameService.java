package com.penchala.yegu.game.service;

import com.penchala.yegu.game.model.Game;
import com.penchala.yegu.game.model.Lobby;
import com.penchala.yegu.game.model.PlayStat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class GameService {

    @Autowired
    StatService statService;

        List<Game> gameList = new ArrayList();
        List<PlayStat> playStats = new ArrayList<>();

    public Integer createNewGame(int userId) {
        Game game = initaliseGame(userId);
        gameList.add(game);
        log.info("A game is added to the games Database");
        return game.getGamePin();
    }

    public Boolean joinGame(int gameId, int playerId) {
        Game game = findGameById(gameId).get();
        if(!game.equals(null)){
            Lobby lobby = game.getGameLobby();
            lobby.addPlayer(playerId);
            return  true;
        }
        return false;
    }

    public void savePlayerStatistics(PlayStat playStat) {
        playStats.add(playStat);
        statService.updateScoreBoard(playStat);
    }
    private Game initaliseGame(int userId){
        int gamePin = new Random().nextInt(9999);
        Date gameCreationDate = new Date();
        Lobby gameLobby = new Lobby();
        gameLobby.setGameId(gamePin);
        Game game = new Game(gamePin,userId,gameCreationDate,gameLobby);
        log.info("A game "+gamePin+" is created at"+gameCreationDate);
        return game;
    }

    private Optional<Game> findGameById(int gameId) {
        //Stream<Game> resultGame = gameList.stream().filter((game -> game.getGamePin().equals(gameId)));
        for (Game game : gameList) {
            if(game.getGamePin().equals(gameId)){
                log.info("A game with Id "+gameId+" exit method returns true");
                return Optional.of(game);
            }
        }
        log.info("A game with Id "+gameId+" does not exit method returns false");
        return null;
    }

    public List<Integer> getLobbyPlayers(int gamePin) {
       Optional<Game> game = findGameById(gamePin);
       Lobby lobby = game.get().getGameLobby();
       return lobby.getLobbyPlayers();
    }


    public PlayStat getPlayAggregrateStat(int gameId, int playerId){
        return statService.generateAggStats(playerId);
    }
}

/* TODO :
*   1. Check for gamepin duplication
*   2. Create a game factory which returns unique game every time called for game
*   3. Convert collection into stream library
*   4. May be if possible convert the whole microservice into functional approach
* */
