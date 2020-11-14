package com.penchala.yegu.kahootclone.controller;

import com.penchala.yegu.kahootclone.model.Player;
import com.penchala.yegu.kahootclone.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;
    /*
    * Path variable
    *
    * */

    @PostMapping("/joinGame/{gamePin}/{nickname}")
    public void joinGame(@PathVariable int gamePin,@PathVariable String nickName){
        playerService.addPlayerToGame(gamePin,nickName);
    }

    @GetMapping("/getPlayers/{gamePin}")
    private List<Player> getPlayers(@PathVariable int gamePin){
        return playerService.getGamePlayers(gamePin);
    }

}
