package org.kata.tennis;

public class Game {
    private final Score score;
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
        checkGameWinner();
    }

    private void checkGameWinner() {
        int player1Score = score.getScorePlayer1();
        int player2Score = score.getScorePlayer2();
        int difference = Math.abs(player1Score - player2Score);

        if (isWinningScore(player1Score, player2Score) && difference >= 2) {
            declareGameWinner(player1Score > player2Score ? Player.PLAYER_1 : Player.PLAYER_2);
        }
    }

    private void declareGameWinner(Player winner) {
        gameWinner = winner;
        if (winner == Player.PLAYER_1) {
            gamePointsPlayer1++;
        } else {
            gamePointsPlayer2++;
        }
        score.resetScore();
    }

    private boolean isWinningScore(int scorePlayer1, int scorePlayer2) {
        return scorePlayer1 >= 4 || scorePlayer2 >= 4;
    }

    public void tiebreakPointWonBy(Player player) {
        if (player == Player.PLAYER_1) tiebreakPointsPlayer1++;
        else if (player == Player.PLAYER_2) tiebreakPointsPlayer2++;
    }

    public int getTiebreakPoints(Player player) {
        return player == Player.PLAYER_1 ? tiebreakPointsPlayer1 : tiebreakPointsPlayer2;
    }

    public Player getWinner() {
        return gameWinner;
    }

    public boolean isFinished() {
        return gameWinner != null;
    }

    public int getGamePoints(Player player) {
        return player == Player.PLAYER_1 ? gamePointsPlayer1 : gamePointsPlayer2;
    }

    public Score getScore() {
        return score;
    }

}
