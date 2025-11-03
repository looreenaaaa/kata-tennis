package org.kata.tennis;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetScoringTest {

    @Test
    public void newSetShouldStartWithZeroGames() {
        Set set = new Set();
        assertEquals(0, set.getGame().getGamePoints(Player.PLAYER_1));
        assertEquals(0, set.getGame().getGamePoints(Player.PLAYER_2));
    }

    @Test
    public void newSetShouldStartWithNoWinner() {
        Set set = new Set();
        assertNull(set.getSetWinner());
    }

    @Test
    public void on6_0Player1ShouldWinSet() {
        Score score = new Score(4,0);
        Game game = new Game(score, 5,0);
        Set set = new Set(0,0, game);

        set.gameWonBy(Player.PLAYER_1);

        assertEquals(1, set.getSets(Player.PLAYER_1));
    }

    @Test
    public void tiebreakAt6_6() {
        Score score = new Score(3,0);
        Game game = new Game(score, 5,6);
        Set set = new Set(0,0,game);

        set.gameWonBy(Player.PLAYER_1);

        assertTrue(set.isTiebreak());
    }

    @Test
    public void player1WinsAtTiebreak7_5() {
        Game game = new Game(6,5);
        Set set = new Set(0,0,game);

        set.pointWonInTiebreak(Player.PLAYER_1);

        assertEquals(Player.PLAYER_1, set.getSetWinner());
        assertTrue(set.isFinished());
        assertEquals(1, set.getSets(Player.PLAYER_1));
    }



}
