package gameMode;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.sun.xml.internal.fastinfoset.tools.TransformInputOutput;
import gameBoard.Board;
import gameBoard.field.Field;
import object.Hat;
import object.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tester for Basic.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-11-05
 */
public class BasicTest {
    private Board gameBoard;
    private Basic gameMode;
    private Field field1;
    private Field field2;
    private Hat hat1;
    private Hat hat2;

    @BeforeEach
    void setUp() {
        gameBoard = new Board();
        gameMode = new Basic(gameBoard, 4);
        field1 = gameBoard.getAllFields().get(0);
        field2 = gameBoard.getAllFields().get(49);
        hat1 = new Hat(1, new Player(1, 1, Color.BLUE));
        hat2 = new Hat(2, new Player(2, 1, Color.RED));
        field1.joinField(hat1);
        field2.joinField(hat2);
    }

    @Test
    @DisplayName("Verify amount of game pieces")
    void verifyAmountOfGamePieces() {
        assertEquals(6, gameMode.getMaxGamePieces());
        assertEquals(4, (new Basic(new Board(), 6)).getMaxGamePieces());
    }

    @Test
    @DisplayName("Catch the victim")
    void catchTheVictim() {
        // gameMode.moveGamePiece(field2, hat2, 3);
        // System.setIn(new ByteArrayInputStream("50".getBytes()));
    }
}
