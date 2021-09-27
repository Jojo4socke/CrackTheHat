package gameMode;

import game.Game;
import object.Player;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Normal game for 2-6 players.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-08-23
 */
public class Basic {
    final int maxHats = 6;
    private int playerCount;
    private ArrayList<Player> players = new ArrayList<>();

    public Basic(int playerCount) {

    }

    @Override
    public String toString() {
        return "Basic{" +
                "  maxHats=" + maxHats +
                ", playerCount=" + playerCount +
                ", players=" + players +
                "Name = Basic" +
                '}';
    }
}
