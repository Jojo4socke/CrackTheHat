package object;

import java.util.List;

/**
 * Game piece in form of a hat.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-08-23
 */
public class Hat {
    // Parameters
    /**
     * @param hatId unique id on the game board
     */
    private int hatId;
    /**
     * @param playerId player who participates
     */
    private int playerId;
    /**
     * @param currentField field number on which the game piece is located
     */
    private int currentField;
    /**
     * @param amountCapturedHats amount of hats that have been captured
     */
    private int amountCapturedHats;
    /**
     * @param isCaptured indicates whether this hat is captured or not
     */
    private boolean isCaptured;
    /**
     * @param capturedHats list of all hats that are currently captured by the hat
     */
    private List<Hat> capturedHats;

    // Constructors
    /**
     * Constructor to create a hat.
     */
    public Hat() {

    }

}
