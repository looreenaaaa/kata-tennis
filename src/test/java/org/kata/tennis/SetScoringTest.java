package org.kata.tennis;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetScoringTest {

    @Test
    public void newSetShouldStartWithZeroGames() {
        Set set = new Set();
        assertEquals(0, set.getGames(Player.PLAYER_1));
        assertEquals(0, set.getGames(Player.PLAYER_2));
    }

    @Test
    public void newSetShouldStartWithNoWinner() {
        Set set = new Set();
        assertNull(set.getWinner());
    }

    @Test
    public void correctlyAddsGameToPlayer1() {
        Set set = new Set();
        set.addGame(Player.PLAYER_1);
        assertEquals(1, set.getGames(Player.PLAYER_1));
        assertEquals(0, set.getGames(Player.PLAYER_2));
    }

    @Test
    public void on6_0Player1ShouldWinSet() {
        Set set = new Set();
        for (int i=0; i<6;i++) set.addGame(Player.PLAYER_1);
        assertEquals(Player.PLAYER_1, set.getWinner());
    }

    @Test
    public void tiebreakAt6_6() {
        Set set = new Set();
        for (int i=0; i<6; i++) {
            set.addGame(Player.PLAYER_1);
            set.addGame(Player.PLAYER_2);
        }
        assertTrue(set.isTiebreak());
    }
}
