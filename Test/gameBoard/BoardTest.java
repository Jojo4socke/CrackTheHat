package gameBoard;

import gameBoard.field.Field;
import gameBoard.field.HomeField;
import gameBoard.field.SaveField;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void test_generateBoard() {
        Board boardObject = new Board();
        List<Field> board = boardObject.generateBoard();
        assertNotNull(board);
        assertEquals(HomeField.class, board.get(76).getClass());
        assertEquals(SaveField.class, board.get(10).getClass());
        assertEquals(Field.class, board.get(71).getClass());
    }
}