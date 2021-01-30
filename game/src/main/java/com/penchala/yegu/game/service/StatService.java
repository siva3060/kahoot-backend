package com.penchala.yegu.game.service;

import com.penchala.yegu.game.model.PlayStat;
import com.penchala.yegu.game.model.ScoreBoard.ScoreBoard;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StatService {

    private List<ScoreBoard> scoreBoardList = new ArrayList<>();

    public void updateScoreBoard(PlayStat playStat) {
         int currentPlayerScore;

        for (ScoreBoard sc : scoreBoardList) {
            if(sc.getPlayerId() == playStat.getPlayerId()){
                currentPlayerScore = sc.getPlayerScore() + playStat.getPlayScore();
                sc.setPlayerScore(currentPlayerScore);
            }
        }

    }


    public PlayStat generateAggStats(int playerId) {
        int rank = 0;
        Collections.sort(scoreBoardList);
        PlayStat playStat = new PlayStat();
        Iterator<ScoreBoard> scoreBoardIterator = scoreBoardList.listIterator();
        while (scoreBoardIterator.hasNext()){
            rank++;
            ScoreBoard sc = scoreBoardIterator.next();
            if(sc.getPlayerId() == playerId){
                playStat.setPlayerId(playerId);
                playStat.setPlayerRank(rank);
                playStat.setPlayScore(sc.getPlayerScore());
            }
        }
        return playStat;
    }

    }
