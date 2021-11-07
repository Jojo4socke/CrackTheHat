package object;

import java.awt.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tester for Hat.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-11-05
 */
public class HatTest {
    private Hat hat1;
    private Hat hat2;
    private Player player1;
    private Player player2;

    @BeforeEach
    void setUp() {
        hat1 = new Hat(1, new Player(1, 1, Color.BLUE));
        hat2 = new Hat(2, new Player(2, 1, Color.RED));
        player1 = new Player(3, 4, Color.BLACK);
        player2 = new Player(4, 4, Color.YELLOW);
    }

    @Test
    @DisplayName("Catch a victim")
    void catchVictim() {
        hat1.addVictim(hat2);
        assertTrue(hat1.getCapturedHats().contains(hat2));
    }
}
