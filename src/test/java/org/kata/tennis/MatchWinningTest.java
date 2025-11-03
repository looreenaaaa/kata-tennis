package org.kata.tennis;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchWinningTest {

    @Test
    public void matchShouldInitializeCorrectly() {
        Set set = new Set();
        tennisMatch match = new tennisMatch(set);

        assertNull(match.getWinner());
        assertFalse(match.isFinished());
    }

    @Test
    public void player1WinsAt3_0Sets() {
        Score score = new Score(3,0);
        Game game = new Game(score, 5,4);
        Set set = new Set(2,0, game);
        tennisMatch match = new tennisMatch(set);

        match.setWonBy(Player.PLAYER_1);

        assertEquals(Player.PLAYER_1, match.getWinner());
        assertTrue(match.isFinished());
    }

}
