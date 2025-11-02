package org.kata.tennis;

public class Set {
    private int[] games = new int[2];

    public int getGames(Player player) {
        if (player == Player.PLAYER_1) return games[0];
        else return games[1];
    }
}
