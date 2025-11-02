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
}
