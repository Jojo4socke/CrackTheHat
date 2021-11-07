package gameBoard.field;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import object.Hat;
import object.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tester for SaveField.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-11-05
 */
public class SaveFieldTest {
    private SaveField saveField;
    private Hat testHat;
    private List<Hat> hats = new ArrayList<>();

    @BeforeEach
    void setUp() {
        saveField = new SaveField(1);
        testHat = new Hat(4, new Player(4, 1, Color.YELLOW));
        hats.add(new Hat(1, new Player(1, 1, Color.BLUE)));
        hats.add(new Hat(2, new Player(2, 1, Color.RED)));
        hats.add(new Hat(3, new Player(3, 1, Color.BLACK)));
        saveField.joinField(hats.get(0));
        saveField.joinField(hats.get(1));
    }

    @Test
    @DisplayName("Join SaveField with a free spot")
    void joinFreeSaveField() {
        assertTrue(saveField.joinField(testHat));
    }

    @Test
    @DisplayName("Join full SaveField")
    void joinFullSaveField() {
        saveField.joinField(hats.get(2));
        assertFalse(saveField.joinField(testHat));
    }
}
