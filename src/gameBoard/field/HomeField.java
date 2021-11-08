package gameBoard.field;

import object.Player;

/**
 * A home field on the game board.
 * This is where the hats start and where the captive hats are brought.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-08-23
 */
public class HomeField extends Field {
    /**
     * @param player the owner of the home field
     */
    private Player player;

    // Constructors
    /**
     * Constructor to create a home field.
     * @param fieldNumber unique field number on game board
     */
    public HomeField(int fieldNumber) {
        super(fieldNumber);
    }

    // Methods
    /**
     * Getter for player.
     * @return owner of home field.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Setter for player.
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
}
