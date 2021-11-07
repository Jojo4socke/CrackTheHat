package object;

import java.awt.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tester for Player.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-11-05
 */
public class PlayerTest {
    private Player player1;
    private Player player2;

    @BeforeEach
    void setUp() {
        player1 = new Player(1, 2, Color.BLUE);
        player2 = new Player(2, 4, Color.RED);
    }

    @Test
    @DisplayName("Successful creation of hats")
    void testHatCreation() {
        assertEquals(2, player1.getActiveHats().size());
        assertEquals(4, player2.getActiveHats().size());
    }

    @Test
    @DisplayName("Increase amount of captured hats")
    void increaseCapturedHats() {
        player1.increaseAmountCapturedHats();
        assertEquals(1, player1.getAmountCapturedHats());
    }
}
