package com.penchala.yegu.game.model.ScoreBoard;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class ScoreBoard implements Comparable<ScoreBoard>{
    private int  playerId;
    private int playerScore;

    @Override
    public int compareTo(ScoreBoard scoreBoard) {
        return Integer.compare(playerScore,scoreBoard.getPlayerScore());
    }
}
