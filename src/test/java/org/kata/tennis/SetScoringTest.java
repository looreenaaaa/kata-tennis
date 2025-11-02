package org.kata.tennis;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetScoringTest {

    @Test
    public void newSetShouldStartWithZeroGames() {
        Set set = new Set();
        assertEquals(0, set.getGames(Player.PLAYER_1));
        assertEquals(0, set.getGames(Player.PLAYER_2));
    }
}
