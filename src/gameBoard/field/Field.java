package gameBoard.field;

/**
 * A field on the game board.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-08-23
 */
public class Field {
    // Parameters
    /**
     * @param fieldNumber unique field number
     */
    private int fieldNumber;

    // Constructors
    /**
     * Constructor to create a normal field.
     * @param fieldNumber unique field number on game board
     */
    public Field(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

}
