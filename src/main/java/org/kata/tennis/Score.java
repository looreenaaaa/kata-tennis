package org.kata.tennis;

public class Score {
    private int scorePlayer1;
    private int scorePlayer2;

    public Score() {
        this(0,0);
    }

    public Score(int scorePlayer1, int scorePlayer2) {
        this.scorePlayer1 = scorePlayer1;
        this.scorePlayer2 = scorePlayer2;
    }

    public void pointWonBy(Player player) {
        if (player == Player.PLAYER_1) scorePlayer1++;
        else if (player == Player.PLAYER_2) scorePlayer2++;
    }

    @Override
    public String toString() {
        return isDeucePhase() ? translateDeucePhase() : translateRegularScore();
    }

    private String translateRegularScore() {
        return translateSingleScore(scorePlayer1) + "-" + translateSingleScore(scorePlayer2);
    }

    private String translateSingleScore(int score) {
        return switch (score) {
            case 0 -> "love";
            case 1 -> "fifteen";
            case 2 -> "thirty";
            case 3 -> "forty";
            default -> String.valueOf(score);
        };
    }

    private boolean isDeucePhase() {
        return scorePlayer1 >= 3 && scorePlayer2 >= 3;
    }

    private String translateDeucePhase() {
        int scoreDifference = scorePlayer1 - scorePlayer2;
        return switch (scoreDifference) {
            case 0 -> "deuce";
            case 1 -> "advantage player 1";
            case -1 -> "advantage player 2";
            case 2 -> "player 1 wins";
            case -2 -> "player 2 wins";
            default -> translateRegularScore();
        };
    }

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public void resetScore() {
        scorePlayer1 = 0;
        scorePlayer2 = 0;
    }
}
