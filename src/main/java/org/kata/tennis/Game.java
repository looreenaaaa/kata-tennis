package org.kata.tennis;

public class Game {
    private Score score;

    public Game () {
        this.score = new Score(0,0);
    }

    public void pointWonBy(Player player) {
        if (player == Player.PLAYER_1) score.incrementPlayer1();
        else score.incrementPlayer2();
    }

    public int getPointsPlayer1() {
        return this.score.getScorePlayer1();
    }

    public int getPointsPlayer2() {
        return this.score.getScorePlayer2();
    }
}
