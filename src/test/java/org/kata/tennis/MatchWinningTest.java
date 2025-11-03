package org.kata.tennis;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchWinningTest {

    @Test
    public void matchShouldInitializeCorrectly() {
        tennisMatch match = new tennisMatch();
        assertNull(match.getWinner());
        assertFalse(match.isFinished());
    }

    @Test
    public void correctlyAddsSetToPlayer1() {
        tennisMatch match = new tennisMatch();

        match.addSet(Player.PLAYER_1);

        assertEquals(1, match.getSets(Player.PLAYER_1));
        assertEquals(0, match.getSets(Player.PLAYER_2));
    }

    @Test
    public void correctlyAddsSetToPlayer2() {
        tennisMatch match = new tennisMatch();

        match.addSet(Player.PLAYER_2);

        assertEquals(0, match.getSets(Player.PLAYER_1));
        assertEquals(1, match.getSets(Player.PLAYER_2));
    }

}
