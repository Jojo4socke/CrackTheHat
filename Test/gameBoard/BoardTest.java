package gameBoard;

import gameBoard.field.Field;
import gameBoard.field.HomeField;
import gameBoard.field.SaveField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("Sucessful board creation.")
    void createBoardSuccessful() {
        assertNotNull(board);
    }

    @Test
    @DisplayName("Verify different field types.")
    void verifyFieldTypes() {
        assertEquals(HomeField.class, board.getAllFields().get(77).getClass());
        assertEquals(SaveField.class, board.getAllFields().get(10).getClass());
        assertEquals(Field.class, board.getAllFields().get(71).getClass());
    }
}