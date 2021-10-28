package object;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Player that participates in the game.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-08-23
 */
public class Player {
    // Parameters
    /**
     * @param playerId the players id
     */
    private int playerId;
    /**
     * @param playerColor the player's color
     */
    private Color playerColor;
    /**
     * @param activeHats amount of active hats
     */
    private List<Hat> activeHats;
    /**
     * @param amountCapturedHats amount of hats that have been captured
     */
    private int amountCapturedHats;
    /**
     * @param amountStoredHats amount of hats that have been successfully stored
     */
    private int amountStoredHats;

    // Constructors
    /**
     * Constructor to create a player.
     */
    public Player(int playerId, int numberOfHats, Color color) {
        this.playerId = playerId;
        this.playerColor = color;
        this.activeHats = createHats(numberOfHats);
    }

    // Methods
    /**
     * Getter for player's id.
     * @return playerId
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * Getter for player's color.
     * @return playerColor
     */
    public Color getPlayerColor() {
        return playerColor;
    }

    /**
     * Getter for player's active hats.
     * @return activeHats
     */
    public List<Hat> getActiveHats() {
        return activeHats;
    }

    /**
     * Getter for captured hats.
     * @return amountCapturedHats
     */
    public int getAmountCapturedHats() {
        return amountCapturedHats;
    }

    /**
     * Getter for successfully stored hats.
     * @return amountStoredHats
     */
    public int getAmountStoredHats() {
        return amountStoredHats;
    }

    /**
     * Increase amount of captured hats by 1.
     */
    public void increaseAmountCapturedHats() {
        amountCapturedHats += 1;
    }

    /**
     * Increase amount of stored hats for every captured hat that has been taken to home field.
     */
    public void increaseAmountStoredHats(int amountOfHats) {
        amountStoredHats += 1;
    }

    /**
     * Create all hats for the player.
     * @param numberOfHats the amount of hats at the start of the game
     * @return list of generated hats
     */
    private List<Hat> createHats(int numberOfHats) {
        List<Hat> hats = new ArrayList<>();
        for(int i = 1; i <= numberOfHats; i++) {
            hats.add(new Hat(i, this));
        }
        return hats;
    }

    @Override
    public String toString() {
        return playerColor + "(ID: " + playerId + ")";
    }

}
