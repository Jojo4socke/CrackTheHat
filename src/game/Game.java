package game;

import gameBoard.Board;
import gameMode.*;
import object.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    final private int maxHats = 4;
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

    Basic gameMode;

    String gameModeTitle = "Basic";

    // Constructors
    /**
     * Contructor to create a game.
     * @param playerCount number of players to start the game
     */
    public Game(int playerCount, String gameMode) {
        this.playerCount = playerCount;
        this.gameMode = changeGamemMode(gameMode);
        players = createPlayers(playerCount);
        gameBoard = new Board();


        //TODO: create hats
    }

    public static void main(String[] args) {
        runGame();
    }

    /**
     * Gameplay with queries for the players.
     */
    public static void runGame() {
        Scanner sc= new Scanner(System.in);
        System.out.print("How many players are playing?: ");
        String playerCount = sc.nextLine();
        System.out.print("Which Gamemode?: ");
        String gameMode = sc.nextLine();
        Game game = new Game(Integer.parseInt(playerCount), gameMode);
        System.out.println(game);
    }

    /**
     * Choose the next player.
     * @param activePlayer player's turn
     */
    private void nextTurn(int activePlayer) {

    }

    private ArrayList<Player> createPlayers(int playerCount) {
        ArrayList<Player> players = new ArrayList<>();
        for(int i = 1; i <= playerCount; i++) {
            players.add(new Player(maxHats, i));
        }
        return players;
    }

    private Basic changeGamemMode(String gameModeTitle) {
        switch (gameModeTitle) {
            case "Basic":
                gameMode = new Basic(playerCount);
                break;
            case "GoldenHat":
                gameMode = new GoldenHat(playerCount);
                break;
            case "Team":
                gameMode = new Team(playerCount);
                break;
            case "TotalTeam":
                gameMode = new TotalTeam(playerCount);
                break;
            case "Tower":
                gameMode = new Tower(playerCount);
                break;
        }
        return gameMode;
    }

    public String toString() {
        return "PlayerCount: " + playerCount + "\n gameMode: "
                + gameMode.toString() + "\n Players: " + players.toString();
    }

}
