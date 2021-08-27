package gameBoard;

import gameBoard.field.Field;

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
    private static List<Field> generateBoard() {
        //TODO: implement actual board generation
        return null;
    }
}
