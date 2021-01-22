package com.penchala.yegu.game.model;

import lombok.Data;

    @Data
    public  class PlayStat implements Comparable<PlayStat> {
        private int playerId;
        private int playScore;
        private int playerRank;

        @Override
        public int compareTo(PlayStat playStat) {
            return Integer.compare(getPlayScore(),playStat.getPlayScore());
        }
    }
