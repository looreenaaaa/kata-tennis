package org.kata.tennis;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameScoringTest {

    @Test
    public void newGameShouldStartWith0Points() {
        Game game = new Game();
        assertEquals(0, game.getGamePoints(Player.PLAYER_1));
        assertEquals(0, game.getGamePoints(Player.PLAYER_2));
    }

    @Test
    public void newGameShouldStartWithNoWinner() {
        Game game = new Game();
        assertNull(game.getWinner());
    }

    @Test
    public void pointWonByPlayer1ShouldIncreaseScore() {
        Score score = new Score(3,0);
        Game game = new Game(score, 0,0);
        game.pointWonBy(Player.PLAYER_1);
        assertEquals(1, game.getGamePoints(Player.PLAYER_1));
        assertEquals(0, game.getGamePoints(Player.PLAYER_2));
    }

    @Test
    public void pointWonByPlayer2ShouldIncreaseScore() {
        Score score = new Score(0,3);
        Game game = new Game(score, 0,0);
        game.pointWonBy(Player.PLAYER_2);
        assertEquals(0, game.getGamePoints(Player.PLAYER_1));
        assertEquals(1, game.getGamePoints(Player.PLAYER_2));
    }

    @Test
    public void on4_0Player1ShouldWin() {
        Score score = new Score(3,0);
        Game game = new Game(score,0,0);

        game.pointWonBy(Player.PLAYER_1);

        assertTrue(game.isFinished());
        assertEquals(Player.PLAYER_1, game.getWinner());
    }

    @Test
    public void after4_0GameShouldReset() {
        Score score = new Score(3,0);
        Game game = new Game(score, 0,0);

        game.pointWonBy(Player.PLAYER_1);

        // Act
        int scorePlayer1 = game.getScore().getScorePlayer1();
        int scorePlayer2 = game.getScore().getScorePlayer2();

        // Assert
        assertEquals(0, scorePlayer1);
        assertEquals(0, scorePlayer2);
    }
}
