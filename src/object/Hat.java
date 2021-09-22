package object;

import java.util.ArrayList;
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
    private int amountCapturedHats = 0;
    /**
     * @param isCaptured indicates whether this hat is captured or not
     */
    private boolean isCaptured = false;
    /**
     * @param capturedHats list of all hats that are currently captured by the hat
     */
    private ArrayList<Hat> capturedHats = new ArrayList<>();

    // Constructors
    /**
     * Constructor to create a hat.
     */
    public Hat(int hatId, int playerId) {
        this.hatId = hatId;
        this.playerId = playerId;
    }

    public void updateField(int nextField) {
        currentField = nextField;
    }

    public void capture(Hat hat) {
        capturedHats.add(hat);
        hat.isCaptured();
    }

    public void isCaptured() {
        isCaptured = true;
    }



}
