package game;

import gameBoard.Board;
import gameMode.*;
import object.Hat;
import object.Player;

import javax.swing.*;
import java.awt.*;
import java.io.CharArrayWriter;
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
     * @param players list of players who participate in the game
     */
    private List<Player> players;
    /**
     * @param activePlayer current player on turn
     */
    private Player activePlayer;

    private List<Hat> hats;

    private MainMenu mainMenu;

    private JFrame activeWindow;

    private int playerCount;

    Basic gameMode;

    // Constructors
    /**
     * Contructor to create a game.
     * @param playerCount number of players to start the game
     */
    public Game(int playerCount, String gameMode, List<Color> playerColours) {
        gameBoard = new Board();
        this.playerCount = playerCount;
        this.gameMode = changeGameMode(gameMode, gameBoard);
        //this.players = createPlayers(playerCount, playerColours);
        //this.hats = createHats(playerCount);
        this.mainMenu = new MainMenu();

        //TODO: create hats
    }

    // Methods

    /**
     * Runner for a game.
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game(2,"Basic", new ArrayList<Color>(){{add(Color.orange); add(Color.blue);}});
        game.runGame();
    }

    /**
     * Gameplay with queries for the players.
     */
    public void runGame() {
        Scanner sc= new Scanner(System.in);
        System.out.print("How many players are playing?: ");
        String playerCount = sc.nextLine();
//        System.out.print("Which Gamemode?: ");
//        String gameMode = sc.nextLine();
        Game game = new Game(Integer.parseInt(playerCount), "Basic", new ArrayList<Color>(){{add(Color.orange); add(Color.blue);}});
//        while (true) {
            tick();
 //       }
    }

    private void tick() {
        mainMenu.tick();
    }

    /**
     * Choose the next player.
     * @param activePlayer player's turn
     */
    public void nextTurn(int activePlayer) {

    }

    /**
     * Create the players that participate in the game.
     * @param playerCount amount of players
     * @param playerColours list with colors
     * @return list of players
     */
    private List<Player> createPlayers(int playerCount, List<Color> playerColours) {
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < playerCount; i++) {
            players.add(new Player(i, gameMode.getMaxGamePieces(), playerColours.get(i)));
        }
        return players;
    }

    /**
     * Change the game mode.
     * @param gameModeTitle game title
     * @param gameBoard current board
     * @return the rules of the game
     */
    private Basic changeGameMode(String gameModeTitle, final Board gameBoard) {
        switch (gameModeTitle) {
            case "Basic":
                gameMode = new Basic(gameBoard, playerCount);
                break;
            case "GoldenHat":
                gameMode = new GoldenHat(gameBoard, playerCount);
                break;
            case "Team":
                gameMode = new Team(gameBoard, playerCount);
                break;
            case "TotalTeam":
                gameMode = new TotalTeam(gameBoard, playerCount);
                break;
            case "Tower":
                gameMode = new Tower(gameBoard, playerCount);
                break;
        }
        return gameMode;
    }

    /**
     * Creates a String with all participating players.
     * @return list of players as string
     */
    private String printPlayers() {
        String playerString = null;
        for (int i = 0; i < players.size(); i++) {
            playerString += players.get(i).toString();
            if(!(i == players.size() - 1)) {
                playerString += ", ";
            }
        }
        return playerString;
    }

    /**
     * Print game information.
     * @return game mode and participating players
     */
    @Override
    public String toString() {
        return "##############################\n"
                + "GameMode: " + gameMode.toString() + "\n"
                + "Players:  " + printPlayers() + "\n"
                + "##############################\n";
    }

    public void render() {

    }

}
