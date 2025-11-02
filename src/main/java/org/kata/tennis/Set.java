package org.kata.tennis;

public class Set {
    private int[] games;
    private Player winner;
    private boolean tiebreak;

    public Set() {
        this.games = new int[2];
        this.winner = null;
        this.tiebreak = false;
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
}
