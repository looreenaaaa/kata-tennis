package org.kata.tennis;

public class tennisMatch {
    private Set set;
    private Player winner;
    private boolean matchFinished;

    public tennisMatch(Set set, Player winner) {
        this.set = set;
        this.winner = winner;
        this.matchFinished = false;
    }

    public tennisMatch(Set set) {
        this.set = set;
    }

    public void setWonBy(Player player) {
        set.gameWonBy(player);
        int setPointsPlayer1 = set.getSets(Player.PLAYER_1);
        int setPointsPlayer2 = set.getSets(Player.PLAYER_2);
        if (setPointsPlayer1 == 3 || setPointsPlayer2 == 3) {
            if (setPointsPlayer1 == 3) winner = Player.PLAYER_1;
            else winner = Player.PLAYER_2;
            matchFinished = true;
        }
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isFinished() {
        return matchFinished;
    }

    public Set getSet() {
        return set;
    }
}
