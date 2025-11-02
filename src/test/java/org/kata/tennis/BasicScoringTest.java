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

}
