package com.penchala.yegu.kahootclone.service;


import com.penchala.yegu.kahootclone.model.Game;
import com.penchala.yegu.kahootclone.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;


    public void createGame(int gamePin) {
        Game game = new Game();
        game.setGamePin(gamePin);
        gameRepository.save(game);
    }


    public Boolean gameExist(int gamePin) {
        Optional<Game> game = gameRepository.findByGamePin(gamePin);
        if (game.isPresent()) {
            return true;
        }
        return false;
    }
}
