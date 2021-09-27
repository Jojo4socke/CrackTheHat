package object;

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
     * @param activeHats amount of active hats
     */
    private int activeHats;

    private int id;

    private ArrayList<Hat> allHats;

    // Constructors
    /**
     * Constructor to create a player.
     */
    public Player(int activeHats, int id) {
        this.activeHats = activeHats;
        this.id = id;
        this.allHats = createHats();
    }

    private ArrayList<Hat> createHats() {
        ArrayList<Hat> hats = new ArrayList<>();
        for(int i = 1; i <= activeHats; i++) {
            hats.add(new Hat(i,id));
        }
        return hats;
    }
}
