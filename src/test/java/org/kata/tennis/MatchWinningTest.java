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

}
