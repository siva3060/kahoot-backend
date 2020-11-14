package com.penchala.yegu.kahootclone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private Long gameId;
    private int gamePin;

    public int getGamePin() {
        return gamePin;
    }

    public void setGamePin(int gamePin) {
        this.gamePin = gamePin;
    }
}
