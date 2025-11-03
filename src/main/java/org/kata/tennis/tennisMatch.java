package org.kata.tennis;

public class tennisMatch {
    private Set set;
    private Player winner;

    public tennisMatch(Set set, Player winner) {
        this.set = set;
        this.winner = winner;
    }

    public tennisMatch(Set set) {
        this.set = set;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isFinished() {
        return winner != null;
    }

    public Set getSet() {
        return set;
    }
}
