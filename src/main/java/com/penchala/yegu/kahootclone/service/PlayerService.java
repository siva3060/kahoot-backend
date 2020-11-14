package com.penchala.yegu.kahootclone.service;

import com.penchala.yegu.kahootclone.model.Player;
import com.penchala.yegu.kahootclone.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getGamePlayers(int gamePin) {
        return playerRepository.findByGamePin(gamePin);
    }


    public void addPlayerToGame(int gamePin,String nickName) {
        Player player = new Player();
        player.setGamePin(gamePin);
        player.setPlayerNickName(nickName);
        playerRepository.save(player);
    }
}
