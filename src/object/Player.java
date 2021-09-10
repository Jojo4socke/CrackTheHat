package object;

/**
 * Player that participates in the game.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-08-23
 */
public class Player {
    // Parameters
    /**
     * @param activeHats amount of active hats
     */
    private int activeHats;

    // Constructors
    /**
     * Constructor to create a player.
     */
    public Player(int activeHats) {
        this.activeHats = activeHats;
    }

}
