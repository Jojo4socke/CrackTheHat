package gameMode;

import gameBoard.Board;
import gameBoard.field.Field;
import gameBoard.field.SaveField;
import object.Hat;

import java.util.List;
import java.util.Scanner;

/**
 * Normal game for 2-6 players.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-08-23
 */
public class Basic {
    // Parameters
    /**
     * @param gameBoard
     */
    private Board gameBoard;
    /**
     * @param maxGamePieces maximum amount of game pieces at the beginning
     */
    private int maxGamePieces;
    /**
     * @param players amount of players who participate in the game
     */
    private int players;

    // Constructors
    /**
     * Constructor for a basic game.
     *
     * 2-4 players: every player gets 6 game pieces and places them on his home field.
     * 5-6 players: every player gets 4 game pieces and places each of them on his four home fields.
     */
    public Basic(Board gameBoard, int players) {
        this.gameBoard = gameBoard;
        this.players = players;
        if(players > 4) {
            maxGamePieces = 4;
        } else {
            maxGamePieces = 6;
        }
    }

    // Methods
    /**
     * Getter for maximum amount of game pieces per player.
     * @return maximum amount of game pieces for a player
     */
    public int getMaxGamePieces() {
        return maxGamePieces;
    }

    /**
     * Getter for players.
     * @return amount of players who participate
     */
    public int getPlayers() {
        return players;
    }

    /**
     * Move the game piece across the game board to a chosen direction.
     * Try to join a SaveField:
     *   1. maximum of resting game pieces is reached ==> try another move          !!!!!!!!!!!!!!!!!! HUT RESETTEN WG. REKURSION !!!!!!!!!!!!!!!!!!
     *   2. free resting spot ==> move completed
     * Try to join a Field:
     *   1. check if the field is empty ==> move completed
     *   2. check if the field already has game pieces of the player located ==> move completed
     *   3. if the player's game piece meets a foreign game piece with the exact dice number ==> capture the foreign game piece
     * @return the game pieces new location
     */
    public Field moveGamePiece(Field startField, Hat currentHat, int eyes) {
        Field previousField;
        Field currentField = startField;

        for(int i = 1; i <= eyes; i++) {
            previousField = currentField;
            currentField = nextMove(previousField, currentField);
        }

        if(isSaveField(currentField) && !((SaveField) currentField).joinField(currentHat)) {
                System.out.println("Try another move.");
                return moveGamePiece(startField, currentHat, eyes); // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        } else {
            if((isSaveField(currentField) && currentField.getHats().size() < ((SaveField) currentField).getMaxGamePieces())
                    || currentField.getHats().size() == 0
                    || currentHat.getPlayer().getPlayerColor() == currentField.getHats().get(0).getPlayer().getPlayerColor()) {
                currentField.joinField(currentHat);
            } else {
                catchTheVictim(currentField, currentHat);
            }
        }
        startField.leaveField(currentHat);
        return currentField;
    }

    /**
     * Calculate possible moves for the chosen game piece.
     * The first move dictates the direction and the game piece will move automatically.
     * If the game piece reaches a crossing, the player will get a selection for further direction,
     * but can't choose the direction where the game piece came from.
     * @param previousField corresponds to the current field if the game piece hasn't been moved,
     *                      otherwise to the previous field
     * @param currentField the field on which the game piece is located
     * @return new location of the game piece
     */
    private Field nextMove(Field previousField, Field currentField) {
        List<Integer> nextPossibleFields = currentField.getNeighbours();
        if(previousField != currentField) {
            nextPossibleFields.remove(Integer.valueOf(previousField.getFieldNumber()));
        }
        Scanner input = new Scanner(System.in);
        int nextFieldNumber;
        // Choose direction
        if(nextPossibleFields.size() > 1) {
            System.out.println("Possible moves to: " + nextPossibleFields.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(", ", " | "));
            System.out.print("Choose a number from above: ");
            nextFieldNumber = input.nextInt();
            if(!isNeighbour(nextPossibleFields, nextFieldNumber)) {
                nextFieldNumber = nextMove(previousField, currentField).getFieldNumber();
            }
        } else {
            nextFieldNumber = nextPossibleFields.get(0);
        }
        return getFieldByNumber(nextFieldNumber);
    }

    /**
     * Get field object via number of given input.
     * @return field object
     */
    private Field getFieldByNumber(int fieldNumber) {
        for (Field field : gameBoard.getAllFields()) {
            if(field.getFieldNumber() == fieldNumber) {
                return field;
            }
        }
        return null;
    }

    /**
     * Check if given input is a neighbour.
     * @return true/false
     */
    private boolean isNeighbour(List<Integer> neighbours, int input) {
        for (int neighbour : neighbours) {
            if(neighbour == input) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if the field is a SaveField.
     * @return true/false
     */
    private boolean isSaveField(Field field) {
        int fieldNumber = field.getFieldNumber();
        // 1-4 players
        //if(players.size() <= 4) {
        if(fieldNumber == 3
                || fieldNumber == 10
                || fieldNumber == 16
                || fieldNumber == 23
                || fieldNumber == 29
                || fieldNumber == 36
                || fieldNumber == 42
                || fieldNumber == 49
                || fieldNumber == 56
                || fieldNumber == 62
                || fieldNumber == 68
                || fieldNumber == 74
        ) {
            return true;
        } else {
            return false;
        }
        // 5-6 players
        //} else {
        //    if(fieldNumber == 3) {
        //        return true;
        //    } else {
        //        return false;
        //    }
        //}
    }

    /**
     * Catch the victim.
     * A victim can be caught, if the attacker will finish his move on the victims currentField.
     * If the victim is located on a SaveField it's not possible to catch it.
     * @param currentField current currentField
     * @param attacker game piece that joins the currentField
     */
    private void catchTheVictim(Field currentField, Hat attacker) {
        for (int i = 0; i <= currentField.getHats().size(); i++) {
            Hat victim = currentField.getHats().get(i);
            attacker.addVictim(victim);
            victim.setCaptured(true);
        }
        currentField.joinField(attacker);
    }

    /**
     * Print game settings.
     * @return game settings
     */
    @Override
    public String toString() {
        return this.getClass().getName() + "{" +
                "  maxHats=" + getMaxGamePieces() +
                ", playerCount=" + getPlayers() +
                "}";
    }

}
