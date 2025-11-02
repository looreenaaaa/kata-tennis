package org.kata.tennis;

public class Game {
    private final Score score;
    private Player gameWinner;

    public Game() {
        this.score = new Score(0,0);
        this.gameWinner = null;
    }

    public void pointWonBy(Player player) {
        score.pointWonBy(player);
        String result = score.toString();
        if (result.equals("player 1 wins")) gameWinner = Player.PLAYER_1;
        if (result.equals("player 2 wins")) gameWinner = Player.PLAYER_2;
    }

    public Player getWinner() {
        return gameWinner;
    }

    public boolean isFinished() {
        return gameWinner != null;
    }

    public int getPointsPlayer1() {
        return score.getScorePlayer1();
    }

    public int getPointsPlayer2() {
        return score.getScorePlayer2();
    }

}
