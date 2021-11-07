package gameBoard.field;

import java.awt.*;

import object.Hat;
import object.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tester for Field.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-11-05
 */
public class FieldTest {
    private Field field;
    private Hat hat;

    @BeforeEach
    void setUp() {
        field = new Field(0);
        field.setNeighbours4P();
        hat = new Hat(1, new Player(1, 1, Color.BLUE));
    }

    @Test
    @DisplayName("Join Field")
    void joinEmptyField() {
        field.joinField(hat);
        assertTrue(field.getHats().contains(hat));
    }

    @Test
    @DisplayName("Leave Field")
    void leaveField() {
        field.joinField(hat);
        field.leaveField(hat);
        assertFalse(field.getHats().contains(hat));
    }

    @Test
    @DisplayName("Verify neighbours")
    void verifyNeighbours() {
        assertTrue(field.getNeighbours().contains(1));
        assertTrue(field.getNeighbours().contains(51));
        assertTrue(field.getNeighbours().contains(58));
        assertTrue(field.getNeighbours().contains(77));
    }
}
