package gameBoard.field;

import object.Hat;

/**
 * A resting field on the game board.
 * Up to three hats or towers are save and can't be captured.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-08-23
 */
public class SaveField extends Field {
    // Parameters
    /**
     * @param maxGamePieces the maximum of game pieces that can rest on the field
     */
    private final int maxGamePieces = 3;
    /**
     * @param restingGamePieces amount of current game pieces that are resting on the field
     */
    private int restingGamePieces;

    // Constructors
    /**
     * Constructor to create a resting field.
     * @param fieldNumber unique field number on game board
     */
    public SaveField(int fieldNumber) {
        super(fieldNumber);
    }

    // Methods
    /**
     * Get amount of game pieces that are currently resting on the field.
     * @return amount of game pieces
     */
    public int countGamePieces() {
        return restingGamePieces;
    }

    /**
     * Game piece joins field to rest.
     */
    public boolean joinField() {
        if(getHats().size() < maxGamePieces) {
            return true;
        } else {
            System.out.println("Resting not possible!");
            return false;
        }
    }

    /**
     * Game piece leaves resting field.
     */
    public void leaveField(Hat hat) {
        removeHat(hat);
    }

    @Override
    public String toString() {
        return restingGamePieces + "/" + maxGamePieces + " resting spots taken.";
    }

}
