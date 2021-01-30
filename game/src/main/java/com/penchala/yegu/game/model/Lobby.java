package com.penchala.yegu.game.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Lobby {

    private int gameId;
    private List<Integer> lobbyPlayers = new ArrayList<>();

    public void addPlayer(int playerId) {
        lobbyPlayers.add(playerId);
    }
}
