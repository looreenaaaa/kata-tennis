package org.kata.tennis;

public class Score {
    private int scorePlayer1;
    private int scorePlayer2;

    public Score(int scorePlayer1, int scorePlayer2) {
        this.scorePlayer1 = scorePlayer1;
        this.scorePlayer2 = scorePlayer2;
    }

    @Override
    public String toString() {
        return translateSingleScore(this.scorePlayer1) + "-" + translateSingleScore(this.scorePlayer2);
    }

    private static String translateSingleScore(int score) {
        String result = "";
        if (score == 0) result = "love";
        else if (score == 1) result = "fifteen";
        else if (score == 2) result = "thirty";
        return result;
    }
}
