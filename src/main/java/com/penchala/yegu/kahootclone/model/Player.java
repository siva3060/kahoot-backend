package com.penchala.yegu.kahootclone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private long playerId;
    private String playerNickName;
    private long gamePin;

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerNickName() {
        return playerNickName;
    }

    public void setPlayerNickName(String playerNickName) {
        this.playerNickName = playerNickName;
    }

    public long getGamePin() {
        return gamePin;
    }

    public void setGamePin(long gameId) {
        this.gamePin = gamePin;
    }
}
