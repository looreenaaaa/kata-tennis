package org.kata.tennis;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchWinningTest {

    @Test
    public void matchShouldInitializeCorrectly() {
        tennisMatch match = new tennisMatch();
        assertNull(match.getWinner());
    }
}
