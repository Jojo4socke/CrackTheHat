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
     * Get amount of maximum game pieces that can rest on the field.
     * @return maximum of game pieces which can rest on the field
     */
    public int getMaxGamePieces() {
        return maxGamePieces;
    }

    /**
     * Game piece joins field to rest.
     */
    @Override
    public boolean joinField(Hat hat) {
        if(getHats().size() < maxGamePieces) {
            return super.joinField(hat);
        } else {
            System.out.println("Maximum of game pieces resting!");
            return false;
        }
    }

    @Override
    public String toString() {
        return restingGamePieces + "/" + maxGamePieces + " resting spots taken.";
    }

}
