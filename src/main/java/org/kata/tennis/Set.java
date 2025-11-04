package org.kata.tennis;

public class Set {
    private int setPointsPlayer1;
    private int setPointsPlayer2;
    private Game currentGame;
    private Player setWinner;
    private boolean tiebreak;

    public Set() {
        this(0,0,new Game());
    }

    public Set(int setPointsPlayer1, int setPointsPlayer2, Game currentGame) {
        this.setPointsPlayer1 = setPointsPlayer1;
        this.setPointsPlayer2 = setPointsPlayer2;
        this.currentGame = currentGame;
        checkTiebreak();
    }

    public void gameWonBy(Player player) {
        if (isFinished()) return;

        currentGame.pointWonBy(player);

        if (currentGame.isFinished()) {
            checkTiebreak();
            checkSetWinner();
            if (!isFinished()) {
                prepareNextGame();
            }
        }
    }

    private void checkSetWinner() {
        if (tiebreak) {
            checkTiebreakWinner();
        } else {
            checkRegularSetWinner();
        }
    }

    private void checkRegularSetWinner() {
        int gamesWonPlayer1 = currentGame.getGamePoints(Player.PLAYER_1);
        int gamesWonPlayer2 = currentGame.getGamePoints(Player.PLAYER_2);
        int difference = Math.abs(gamesWonPlayer1 - gamesWonPlayer2);
        boolean hasWinningScore = gamesWonPlayer1 >= 6 || gamesWonPlayer2 >= 6;

        if (hasWinningScore && difference >= 2) {
            setWinner = gamesWonPlayer1 > gamesWonPlayer2 ? Player.PLAYER_1 : Player.PLAYER_2;
            addSet(setWinner);
        }
    }

    private void checkTiebreakWinner() {
        int pointsPlayer1 = currentGame.getTiebreakPoints(Player.PLAYER_1);
        int pointsPlayer2 = currentGame.getTiebreakPoints(Player.PLAYER_2);
        int difference = Math.abs(pointsPlayer1 - pointsPlayer2);

        if ((pointsPlayer1 >= 7 || pointsPlayer2 >= 7) && difference >= 2) {
            setWinner = pointsPlayer1 > pointsPlayer2 ? Player.PLAYER_1 : Player.PLAYER_2;
            addSet(setWinner);
        }
    }

    private void addSet(Player player) {
        if (player == Player.PLAYER_1) setPointsPlayer1++;
        else setPointsPlayer2++;
    }

    private void checkTiebreak() {
        tiebreak = currentGame.getGamePoints(Player.PLAYER_1) == 6 && currentGame.getGamePoints(Player.PLAYER_2) == 6;
    }

    private void prepareNextGame() {
        currentGame = new Game();
    }

    public void pointWonInTiebreak(Player player) {
        if (tiebreak && !isFinished()) {
            currentGame.tiebreakPointWonBy(player);
            checkTiebreakWinner();
        }
    }

    public int getSets(Player player) { return player == Player.PLAYER_1 ? setPointsPlayer1 : setPointsPlayer2; }
    public boolean isTiebreak() { return tiebreak; }
    public Player getSetWinner() { return setWinner; }
    public boolean isFinished() { return setWinner != null; }
    public Game getCurrentGame() { return currentGame; }

}
