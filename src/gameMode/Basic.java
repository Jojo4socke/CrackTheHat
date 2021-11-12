package gameMode;

import exception.FieldNotFoundException;
import exception.InvalidMoveException;
import gameBoard.Board;
import gameBoard.field.Field;
import gameBoard.field.HomeField;
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
     *   1. maximum of resting game pieces is reached ==> try another move
     *   2. free resting spot ==> move completed
     * Try to join a Field:
     *   1. check if the field is empty ==> move completed
     *   2. check if the field already has game pieces of the player located ==> move completed
     *   3. if the player's game piece meets a foreign game piece with the exact dice number ==> capture the foreign game piece
     * @return the game pieces new location
     */
    public Field moveGamePiece(Field startField, Hat currentHat, int eyes)
            throws InvalidMoveException, FieldNotFoundException {
        Field previousField;
        Field currentField = startField;

        for(int i = 1; i <= eyes; i++) {
            previousField = currentField;
            currentField = nextMove(previousField, currentField);
        }

        if(isSaveField(currentField) && !((SaveField) currentField).joinField(currentHat)) {
            throw new InvalidMoveException("Maximum of game pieces resting! Try another move.");
        } else if(isHomeField(currentField) && currentField.getFieldColor() != currentHat.getPlayer().getPlayerColor()) {
            throw new InvalidMoveException("Move to home field of another player not possible.");
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
    private Field nextMove(Field previousField, Field currentField) throws InvalidMoveException, FieldNotFoundException {
        List<Integer> nextPossibleFields = currentField.getNeighbours();
        int nextFieldNumber;

        if(previousField != currentField) {
            nextPossibleFields.remove(Integer.valueOf(previousField.getFieldNumber()));
        }
        if(nextPossibleFields.size() > 1) {
            nextFieldNumber = chooseDirection(nextPossibleFields);
        } else {
            nextFieldNumber = nextPossibleFields.get(0);
        }
        return getFieldByNumber(nextFieldNumber);
    }

    /**
     * Choose direction for crossings.
     * @param nextPossibleFields the players next possible moves
     * @return chosen field number
     */
    private int chooseDirection(List<Integer> nextPossibleFields) throws InvalidMoveException {
        Scanner input = new Scanner(System.in);
        int nextFieldNumber;
        System.out.println("Possible moves to: " + nextPossibleFields.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(", ", " | "));
        System.out.print("Choose a number from above: ");
        nextFieldNumber = input.nextInt();
        if(nextPossibleFields.contains(nextFieldNumber)) {
            return nextFieldNumber;
        } else {
            throw new InvalidMoveException("Chosen number is not a neighbour.");
        }
    }

    /**
     * Get field object via number of given input.
     * @return field object
     */
    private Field getFieldByNumber(int fieldNumber) throws FieldNotFoundException {
        for (Field field : gameBoard.getAllFields()) {
            if(field.getFieldNumber() == fieldNumber) {
                return field;
            }
        }
        throw new FieldNotFoundException("fieldNumber not found.");
    }

    /**
     * Check if the field is a SaveField.
     * @return true/false
     */
    private boolean isSaveField(Field field) {
        return field.getClass() == SaveField.class;
    }

    /**
     * Check if the field is a HomeField.
     * @return true/false
     */
    private boolean isHomeField(Field field) {
        return field.getClass() == HomeField.class;
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
