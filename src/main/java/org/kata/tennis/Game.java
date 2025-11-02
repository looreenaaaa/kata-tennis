package org.kata.tennis;

public class Game {
    private Score score;
    private boolean finished;
    private Player gameWinner;
    private int[] gameScore;

    public Game() {
        this.score = new Score(0,0);
        this.finished = false;
        this.gameWinner = null;
        this.gameScore = new int[2];
    }

    public void pointWonBy(Player player) {
        if (player == Player.PLAYER_1) score.incrementPlayer1();
        else score.incrementPlayer2();
        checkFinish();
    }

    private void checkFinish() {
        int scorePlayer1 = score.getScorePlayer1();
        int scorePlayer2 = score.getScorePlayer2();
        int scoreDifference = Math.abs(scorePlayer1 - scorePlayer2);
        if ((scorePlayer1 >= 4 || scorePlayer2 >= 4) && scoreDifference >= 2) {
            this.finished = true;
            if (Math.max(scorePlayer1, scorePlayer2) == scorePlayer1) {
                this.gameWinner = Player.PLAYER_1;
                addGameScore();
            }
            else {
                this.gameWinner = Player.PLAYER_2;
                addGameScore();
            }
            score.resetScore();
        }
    }

    public int getGameScorePlayer1() {
        return gameScore[0];
    }

    public int getGameScorePlayer2() {
        return gameScore[1];
    }

    public int getPointsPlayer1() {
        return score.getScorePlayer1();
    }

    public int getPointsPlayer2() {
        return score.getScorePlayer2();
    }

    private void addGameScore() {
        if (this.gameWinner == Player.PLAYER_1) gameScore[0]++;
        else gameScore[1]++;
    }
}
