package game;

import gameBoard.Board;
import object.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a game board and starts the game.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-08-23
 */
public class Game {
    // Parameters
    /**
     * @param gameBoard the game board
     */
    private Board gameBoard;
    /**
     * @param maxHats maximum amount of hats
     */
    private int maxHats;
    /**
     * @param playerCount number of players
     */
    private int playerCount;
    /**
     * @param players list of players who participate in the game
     */
    private ArrayList<Player> players;
    /**
     * @param activePlayer current player on turn
     */
    private Player activePlayer;

    // Constructors
    /**
     * Contructor to create a game.
     * @param numberOfPlayers number of players to start the game
     */
    public Game(int numberOfPlayers, String gameMode) {
        playerCount = numberOfPlayers;

        for(int i = 1; i <= playerCount; i++) {
            players.add(new Player());
        }
        // create players
        // create hats
        // create game board
    }

    /**
     * Gameplay with queries for the players.
     */
    public static void runGame() {

    }

    /**
     * Choose the next player.
     * @param activePlayer player's turn
     */
    private static void nextTurn(int activePlayer) {

    }

}
