package org.kata.tennis;

public class Set {
    private int setPointsPlayer1;
    private int setPointsPlayer2;
    private Game game;
    private Player setWinner;
    private boolean tiebreak;

    public Set() {
        this.setPointsPlayer1 = 0;
        this.setPointsPlayer2 = 0;
        this.game = new Game();
        this.setWinner = null;
        this.tiebreak = false;
    }

    public Set(int setPointsPlayer1, int setPointsPlayer2, Game games) {
        this.setPointsPlayer1 = setPointsPlayer1;
        this.setPointsPlayer2 = setPointsPlayer2;
        this.game = games;
    }

    public Game getGame() {
        return game;
    }

    public int getSets(Player player) {
        int result = 0;
        if (player == Player.PLAYER_1) result = setPointsPlayer1;
        else if (player == Player.PLAYER_2) result = setPointsPlayer2;
        return result;
    }

    public Player getSetWinner() {
        return setWinner;
    }

    public void gameWonBy(Player player) {
        game.pointWonBy(player);
        int player1GamePoints = game.getGamePoints(Player.PLAYER_1);
        int player2GamePoints = game.getGamePoints(Player.PLAYER_2);
        int difference = Math.abs(player1GamePoints - player2GamePoints);
        checkTieBreak();
        if (tiebreak) {
            game.tiebreakPointWonBy(player);
            checkTiebreakWinner();
        } else {
            if ((player1GamePoints >= 6 || player2GamePoints >= 6) && difference >= 2) {
                if (player1GamePoints > player2GamePoints) {
                    setPointsPlayer1++;
                    setWinner = Player.PLAYER_1;
                } else if (player2GamePoints > player1GamePoints) {
                    setPointsPlayer2++;
                    setWinner = Player.PLAYER_2;
                }
            }
        }
    }

    public void pointWonInTiebreak(Player player) {
        game.tiebreakPointWonBy(player);
        checkTiebreakWinner();
    }

    private void checkTiebreakWinner() {
        int tiebreakPointsPlayer1 = game.getTiebreakPoints(Player.PLAYER_1);
        int tiebreakPointsPlayer2 = game.getTiebreakPoints(Player.PLAYER_2);
        int difference = Math.abs(tiebreakPointsPlayer1 - tiebreakPointsPlayer2);
        if ((tiebreakPointsPlayer1 >= 7 || tiebreakPointsPlayer2 >= 7) && difference >= 2) {
            if (tiebreakPointsPlayer1 > tiebreakPointsPlayer2) {
                setPointsPlayer1++;
                setWinner = Player.PLAYER_1;
            } else if (tiebreakPointsPlayer2 > tiebreakPointsPlayer1){
                setPointsPlayer2++;
                setWinner = Player.PLAYER_2;
            }
        } else {
            pointWonInTiebreak(Player.PLAYER_1);
        }
    }

    public boolean isTiebreak() {
        return tiebreak;
    }

    private void checkTieBreak() {
        if (game.getGamePoints(Player.PLAYER_1) == 6 && game.getGamePoints(Player.PLAYER_2) == 6) tiebreak = true;
    }

    public boolean isFinished() {
        return setWinner != null;
    }

}
