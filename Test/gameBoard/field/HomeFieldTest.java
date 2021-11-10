package gameBoard.field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tester for HomeField.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-11-05
 */
public class HomeFieldTest {
    private HomeField homeField;

    @BeforeEach
    void setUp() {
        homeField = new HomeField(77);
        homeField.setNeighbours4P();
    }

    @Test
    @DisplayName("HomeField can just have 1 neighbour")
    void verifyNeighbours() {
        assertEquals(1, homeField.getNeighbours().size());
    }
}
