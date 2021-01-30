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
        Game game = initialiseGame(userId);
        gameList.add(game);
        log.info("A game is added to the games Database");
        return game.getGamePin();
    }

    public Boolean joinGame(int gameId, int playerId) {
        Optional<Game> game = findGameById(gameId);
       if(game.isPresent()){
           Lobby lobby = game.get().getGameLobby();
            lobby.addPlayer(Integer.valueOf(playerId));
            log.info("Player "+playerId+" has been joined successfully to the lobby");
            return true;
        }
            return  false;
    }

    public void savePlayerStatistics(PlayStat playStat) {
        playStats.add(playStat);
        statService.updateScoreBoard(playStat);
    }

    private Game initialiseGame(int userId){
        Lobby gameLobby = new Lobby();
        gameLobby.setGameId(new Random().nextInt(9999));
        log.info("A game with gamePin "+gameLobby.getGameId()+" is created ");
        return new Game(gameLobby.getGameId(),userId,new Date(),gameLobby);
    }

    private Optional<Game> findGameById(int gameId) {
        //Stream<Game> resultGame = gameList.stream().filter((game -> game.getGamePin().equals(gameId)));
        for (Game game : gameList) {
            if(game.getGamePin().equals(Integer.valueOf(gameId))){
                log.info("A game with Id "+gameId+" exit method returns true");
                return Optional.of(game);
            }
        }
        log.info("A game with Id "+gameId+" does not exit method returns false");
        return Optional.empty();
    }

    public List<Integer> getLobbyPlayers(int gamePin) {
       Optional<Game> game = findGameById(gamePin);
       Lobby lobby = game.get().getGameLobby();
       log.info("Found lobby with player count "+lobby.getLobbyPlayers().size());
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
