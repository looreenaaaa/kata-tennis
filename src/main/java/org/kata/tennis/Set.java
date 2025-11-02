package org.kata.tennis;

public class Set {
    private int[] games;
    private Player winner;
    private boolean tiebreak;
    private int tiebreakPointsPlayer1;
    private int tiebreakPointsPlayer2;

    public Set() {
        this.games = new int[2];
        this.winner = null;
        this.tiebreak = false;
        this.tiebreakPointsPlayer1 = 0;
        this.tiebreakPointsPlayer2 = 0;
    }

    public int getGames(Player player) {
        if (player == Player.PLAYER_1) return games[0];
        else return games[1];
    }

    public Player getWinner() {
        return this.winner;
    }

    public void addGame(Player gameWinner) {
        if (gameWinner == Player.PLAYER_1) games[0]++;
        else games[1]++;

        checkTieBreak();
        checkSetWinner();
    }

    public void pointWonInTiebreak(Player player) {
        if (player == Player.PLAYER_1) tiebreakPointsPlayer1++;
        else tiebreakPointsPlayer2++;

        checkTiebreakWinner();
    }

    private void checkTiebreakWinner() {
        int difference = Math.abs(tiebreakPointsPlayer1 - tiebreakPointsPlayer2);
        if ((tiebreakPointsPlayer1 >= 7 || tiebreakPointsPlayer2 >= 7) && difference >= 2) {
            if (tiebreakPointsPlayer1 > tiebreakPointsPlayer2) {
                winner = Player.PLAYER_1;
            } else {
                winner = Player.PLAYER_2;
            }
        }
    }

    private void checkSetWinner() {
        int difference = Math.abs(games[0] - games[1]);
        if ((games[0] >= 6 || games[1] >= 6) && difference >= 2) {
            if (games[0] > games[1]) {
                winner = Player.PLAYER_1;
            } else {
                winner = Player.PLAYER_2;
            }
        }
    }

    public boolean isTiebreak() {
        return tiebreak;
    }

    private void checkTieBreak() {
        if (games[0] == 6 && games[1] == 6) tiebreak = true;
    }

    public boolean isFinished() {
        return winner != null;
    }

    public int getTiebreakPointsPlayer1() {
        return tiebreakPointsPlayer1;
    }

    public int getTiebreakPointsPlayer2() {
        return tiebreakPointsPlayer2;
    }
}
