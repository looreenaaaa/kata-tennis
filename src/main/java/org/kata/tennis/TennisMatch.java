package org.kata.tennis;

public class TennisMatch {
    private final Set currentSet;
    private Player winner;
    private boolean matchFinished;

    public TennisMatch(Set currentSet) {
        this.currentSet = currentSet;
        this.matchFinished = false;
    }

    public void setWonBy(Player player) {
        if (matchFinished) return;

        currentSet.gameWonBy(player);

        if (currentSet.isFinished()) {
            checkMatchWinner();
        }
    }

    private void checkMatchWinner() {
        int setsPlayer1 = currentSet.getSets(Player.PLAYER_1);
        int setsPlayer2 = currentSet.getSets(Player.PLAYER_2);

        if (setsPlayer1 == 3 || setsPlayer2 == 3) {
            winner = setsPlayer1 == 3 ? Player.PLAYER_1 : Player.PLAYER_2;
            matchFinished = true;
        }
    }

    public Player getWinner() { return winner; }

    public boolean isFinished() { return matchFinished; }

}
