package org.kata.tennis;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameScoringTest {

    @Test
    public void on4_0ShouldAdd1ToGameScorePlayer1() {
        // Arrange
        Game game = new Game();

        game.pointWonBy(Player.PLAYER_1);
        game.pointWonBy(Player.PLAYER_1);
        game.pointWonBy(Player.PLAYER_1);

        int pointsBefore = game.getPointsPlayer1();

        // Act
        game.pointWonBy(Player.PLAYER_1);
        int pointsAfter = game.getPointsPlayer1();
        int difference = pointsAfter - pointsBefore;

        // Assert
        assertEquals(1,  difference);
    }

    @Test
    public void after4_0ShouldResetScore() {
        // Arrange
        Game game = new Game();

        game.pointWonBy(Player.PLAYER_1);
        game.pointWonBy(Player.PLAYER_1);
        game.pointWonBy(Player.PLAYER_1);
        game.pointWonBy(Player.PLAYER_1);

        // Act
        int score = game.getPointsPlayer1();

        // Assert
        assertEquals(0, score);
    }
}
