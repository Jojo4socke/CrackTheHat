package gameMode;

import gameBoard.Board;
import object.Player;

/**
 * Golden hat mode for 2-6 players.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-08-23
 */
public class GoldenHat extends Basic {
    // Parameters
    /**
     * @param goldenHatOwner
     */
    private Player goldenHatOwner = null;

    // Constructors
    public GoldenHat(Board gameBoard, int playerCount) {
        super(gameBoard, playerCount);
    }

    // Methods
    /**
     * Print game settings.
     * @return game settings
     */
    @Override
    public String toString() {
        return this.getClass().getName() + "{" +
                "  maxHats=" + getMaxGamePieces() +
                ", playerCount=" + getPlayers() +
                ", goldenHatOwner=" + goldenHatOwner.getPlayerId() +
                "}";
    }

}
