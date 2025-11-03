package org.kata.tennis;

public class Game {
    private Score score;
    private Player gameWinner;
    private int gamePointsPlayer1;
    private int gamePointsPlayer2;
    private int tiebreakPointsPlayer1;
    private int tiebreakPointsPlayer2;

    public Game(Score score,
                Player gameWinner,
                int gamePointsPlayer1,
                int gamePointsPlayer2,
                int tiebreakPointsPlayer1,
                int tiebreakPointsPlayer2) {
        this.score = score;
        this.gameWinner = gameWinner;
        this.gamePointsPlayer1 = gamePointsPlayer1;
        this.gamePointsPlayer2 = gamePointsPlayer2;
        this.tiebreakPointsPlayer1 = tiebreakPointsPlayer1;
        this.tiebreakPointsPlayer2 = tiebreakPointsPlayer2;
    }

    public Game() {
        this(new Score(), 0, 0);
    }

    public Game(Score score, int gamePointsPlayer1, int gamePointsPlayer2) {
        this(score,
                null,
                gamePointsPlayer1,
                gamePointsPlayer2,
                0,
                0);
    }

    public Game(int gamePointsPlayer1, int gamePointsPlayer2) {
        this(new Score(), gamePointsPlayer1, gamePointsPlayer2);
    }

    public void pointWonBy(Player player) {
        score.pointWonBy(player);
        int player1Score = score.getScorePlayer1();
        int player2Score = score.getScorePlayer2();
        int difference = Math.abs(player1Score - player2Score);
        if ((player1Score >= 4 || player2Score >= 4) && difference >= 2) {
            if (player1Score > player2Score) {
                gamePointsPlayer1++;
                gameWinner = Player.PLAYER_1;
            }
            else {
                gamePointsPlayer2++;
                gameWinner = Player.PLAYER_2;
            }
            score.resetScore();
        }
    }

    public void tiebreakPointWonBy(Player player) {
        if (player == Player.PLAYER_1) tiebreakPointsPlayer1++;
        else tiebreakPointsPlayer2++;
    }

    public int getTiebreakPointsPlayer1() {
        return tiebreakPointsPlayer1;
    }

    public int getTiebreakPointsPlayer2() {
        return tiebreakPointsPlayer2;
    }

    public Player getWinner() {
        return gameWinner;
    }

    public boolean isFinished() {
        return gameWinner != null;
    }

    public int getGamePoints(Player player) {
        if (player == Player.PLAYER_1) return gamePointsPlayer1;
        else return gamePointsPlayer2;
    }

    public void reset() {
        score.resetScore();
        gameWinner = null;
    }

    public Score getScore() {
        return score;
    }



}
