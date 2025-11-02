package org.kata.tennis;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicScoringTest {

    @Test
    public void on0_0ShouldReturnLoveLove() {
        // Arrange
        Score score = new Score(0, 0);

        // Act
        String result = score.toString();

        // Assert
        assertEquals("love-love",  result);
    }

    @Test
    public void on1_0ShouldReturnFifteenLove() {
        // Arrange
        Score score = new Score(1, 0);

        // Act
        String result = score.toString();

        // Assert
        assertEquals("fifteen-love",  result);
    }

    @Test
    public void on2_1ShouldReturnThirtyFifteen() {
        // Arrange
        Score score = new Score(2, 1);

        // Act
        String result = score.toString();

        // Assert
        assertEquals("thirty-fifteen",  result);
    }

    @Test
    public void on3_2ShouldReturnFortyThirty() {
        // Arrange
        Score score = new Score(3, 2);

        // Act
        String result = score.toString();

        // Assert
        assertEquals("forty-thirty",  result);
    }

    @Test
    public void on3_3ShouldReturnDeuce() {
        // Arrange
        Score score = new Score(3, 3);

        // Act
        String result = score.toString();

        // Assert
        assertEquals("deuce",  result);
    }

}
