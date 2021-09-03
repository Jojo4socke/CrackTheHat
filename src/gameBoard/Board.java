package gameBoard;

import gameBoard.field.Field;
import gameBoard.field.HomeField;
import gameBoard.field.SaveField;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a game board.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-08-23
 */
public class Board {
    // Parameters
    /**
     * @param allFields list of all fields on the game board
     */
    private List<Field> allFields;

    // Constructors
    /**
     * Constructor to create a board.
     */
    public Board() {
        allFields = generateBoard();
    }

    // Methods
    /**
     * Create the fields on the game board.
     * @return all fields on the board
     */
    public List<Field> generateBoard() {
        //TODO: implement actual board generation
        ArrayList<Field> board = new ArrayList<>();
        for(int i = 0; i < 80; i++) {
            if (i == 3 || i == 10 || i == 16 || i == 23 || i == 29 || i == 36 ||
                    i == 42 || i == 49 || i == 56 || i == 62 || i == 68 || i == 74) {
                board.add(new SaveField(i));
            } else if (i > 75) {
                board.add(new HomeField(i));
            } else {
                board.add(new Field(i));
            }
        }
        return board;
    }
}
