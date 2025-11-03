package org.kata.tennis;

public class Score {
    private int scorePlayer1;
    private int scorePlayer2;

    public Score() {
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
    }

    public Score(int scorePlayer1, int scorePlayer2) {
        this.scorePlayer1 = scorePlayer1;
        this.scorePlayer2 = scorePlayer2;
    }

    public void pointWonBy(Player player) {
        if (player == Player.PLAYER_1) scorePlayer1++;
        else scorePlayer2++;
    }

    @Override
    public String toString() {
        String result = "";
        if (isDeucePhase(scorePlayer1, scorePlayer2)) {
            result = translateDeucePhase(scorePlayer1, scorePlayer2);
        } else {
            result = translateSingleScore(scorePlayer1) + "-" + translateSingleScore(scorePlayer2);
        }
        return result;
    }

    private static String translateSingleScore(int score) {
        String result = "";
        if (score == 0) result = "love";
        else if (score == 1) result = "fifteen";
        else if (score == 2) result = "thirty";
        else if (score == 3) result = "forty";
        return result;
    }

    private static boolean isDeucePhase(int scorePlayer1, int scorePlayer2) {
        return scorePlayer1 >= 3 && scorePlayer2 >= 3;
    }

    private static String translateDeucePhase(int scorePlayer1, int scorePlayer2) {
        String result = "";
        int scoreDifference = scorePlayer1 - scorePlayer2;
        if (scoreDifference == 0) result = "deuce";
        else if (scoreDifference == 1) result = "advantage player 1";
        else if (scoreDifference == -1) result = "advantage player 2";
        else if (scoreDifference == 2) result = "player 1 wins";
        else if (scoreDifference == -2) result = "player 2 wins";
        return result;
    }

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public void resetScore() {
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
    }
}
