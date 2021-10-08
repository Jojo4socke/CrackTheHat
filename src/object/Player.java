package object;

import java.awt.*;
import java.util.ArrayList;

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
     * @param amountCapturedHats amount of hats that have been captured
     */
    private int amountCapturedHats;
    /**
     * @param activeHats amount of active hats
     */
    private int activeHats;

    private ArrayList<Hat> allHats;

    private Color playerColor;

    // Constructors
    /**
     * Constructor to create a player.
     */
    public Player(int playerId, int activeHats, Color color) {
        this.activeHats = activeHats;
        this.playerId = playerId;
        this.playerColor = color;
        this.allHats = createHats();
    }

    // Methods
    /**
     * Getter for playerId.
     * @return playerId
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * Getter for allHats.
     * @return allHats
     */
    public ArrayList<Hat> getAllHats() {
        return this.allHats;
    }

    private ArrayList<Hat> createHats() {
        ArrayList<Hat> hats = new ArrayList<>();
        for(int i = 1; i <= activeHats; i++) {
            hats.add(new Hat(i, playerId, this));
        }
        return hats;
    }

    public void increaseAmountCapturedHats() {
        amountCapturedHats += 1;
    }

    public Color getPlayerColor() {
        return playerColor;
    }

    @Override
    public String toString() {
        return playerColor + "(ID: " + playerId + ")";
    }
}
