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
        if (isDeucePhase(this.scorePlayer1, this.scorePlayer2)) {
            return translateDeucePhase(this.scorePlayer1, this.scorePlayer2);
        } else {
            return translateSingleScore(this.scorePlayer1) + "-" + translateSingleScore(this.scorePlayer2);
        }
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
        return result;
    }
}
