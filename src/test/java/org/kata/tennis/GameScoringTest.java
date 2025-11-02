package org.kata.tennis;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameScoringTest {

    @Test
    public void newGameShouldStartWith0Points() {
        Game game = new Game();
        assertEquals(0, game.getPoints(Player.PLAYER_1));
        assertEquals(0, game.getPoints(Player.PLAYER_2));
    }

    @Test
    public void newGameShouldStartWithNoWinner() {
        Game game = new Game();
        assertNull(game.getWinner());
    }

    @Test
    public void pointWonByPlayer1ShouldIncreaseScore() {
        Game game = new Game();
        game.pointWonBy(Player.PLAYER_1);
        assertEquals(1, game.getPoints(Player.PLAYER_1));
        assertEquals(0, game.getPoints(Player.PLAYER_2));
    }

    @Test
    public void pointWonByPlayer2ShouldIncreaseScore() {
        Game game = new Game();
        game.pointWonBy(Player.PLAYER_2);
        assertEquals(0, game.getPoints(Player.PLAYER_1));
        assertEquals(1, game.getPoints(Player.PLAYER_2));
    }

    @Test
    public void on4_0Player1ShouldWin() {
        Game game = new Game();
        for (int i=0; i<4; i++) game.pointWonBy(Player.PLAYER_1);
        assertTrue(game.isFinished());
        assertEquals(Player.PLAYER_1, game.getWinner());
    }

    @Test
    public void after4_0ShouldResetScore() {
        // Arrange
        Game game = new Game();
        for (int i=0; i<4; i++) game.pointWonBy(Player.PLAYER_1);

        // Act
        game.reset();
        int scorePlayer1 = game.getPoints(Player.PLAYER_1);
        int scorePlayer2 = game.getPoints(Player.PLAYER_2);

        // Assert
        assertFalse(game.isFinished());
        assertNull(game.getWinner());
        assertEquals(0, scorePlayer1);
        assertEquals(0, scorePlayer2);
    }
}
