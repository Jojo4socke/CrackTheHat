package gameBoard.field;

/**
 * A resting field on the game board.
 * Up to three hats or towers are save and can't be captured.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-08-23
 */
public class SaveField extends Field {
    // Constructors
    /**
     * Constructor to create a resting field.
     * @param fieldNumber unique field number on game board
     */
    public SaveField(int fieldNumber) {
        super(fieldNumber);
    }

}
