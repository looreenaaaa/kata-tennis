package org.kata.tennis;

public class tennisMatch {
    private int[] sets;
    private Player winner;

    public tennisMatch() {
        this.sets = new int[2];
        this.winner = null;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isFinished() {
        return winner != null;
    }

    public void addSet(Player player) {
        if (player == Player.PLAYER_1) sets[0]++;
        else sets[1]++;
    }

    public int getSets(Player player) {
        if (player == Player.PLAYER_1) return sets[0];
        else return sets[1];
    }
}
