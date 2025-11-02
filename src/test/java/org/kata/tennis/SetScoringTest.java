package org.kata.tennis;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetScoringTest {

    @Test
    public void player1WinsSetAt6_0() {
        // Arrange
        Game game = new Game();
        Set set = new Set();
        int before = set.getSetScorePlayer1();

        // Act
        for (int i=0;i<6;i++) {
            while (!game.isFinished()) {
                game.pointWonBy(Player.PLAYER_1);
            }
        }
        int after = set.getSetScorePlayer1();
        int difference = after - before;

        // Assert
        assertEquals(1,  difference);
    }
}
