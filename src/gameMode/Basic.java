package gameMode;

import gameBoard.Board;
import gameBoard.field.Field;
import gameBoard.field.SaveField;
import object.Hat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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
     * @param maxHats maximum amount of hats at the beginning
     */
    private int maxHats;
    /**
     * @param players amount of players who participate in the game
     */
    private int players;

    // Constructors
    /**
     * Constructor for a basic game.
     */
    public Basic(Board gameBoard, int players) {
        this.gameBoard = gameBoard;
        if(players > 4) {
            maxHats = 4;
        } else {
            maxHats = 6;
        }
    }

    // Methods
    /**
     * Getter for maxHats.
     * @return maximum amount of hats
     */
    public int getMaxHats() {
        return maxHats;
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
     */
    public Field moveGamePiece(Field startField, Hat currentHat, int eyes) {
        Field previousField = null;
        Field currentField = startField;

        for(int i = 1; i <= eyes; i++) {
            previousField = currentField;
            currentField = nextMove(previousField, currentField);
        }

        if(isSaveField(currentField)) {
            if(((SaveField) currentField).countGamePieces() <= 3) {
                return currentField;
            } else {
                System.out.println("Move not possible. Try again.");
                return moveGamePiece(startField, currentHat, eyes);
            }
        } else {
            // change
            catchTheVictim(currentField, currentHat);
        }
        return currentField;
    }

    /**
     * Choose from next possible moves.
     * @param currentField
     * @return
     */
    private Field nextMove(Field previousField, Field currentField) {
        ArrayList<Integer> nextPossibleFields = currentField.getNeighbours();
        Field nextField = null;
        if(previousField != null) {
            nextPossibleFields.remove(previousField.getFieldNumber());
        }
        Scanner input = new Scanner(System.in);
        int nextFieldNumber;
        // Choose direction
        if(nextPossibleFields.size() > 1) {
            System.out.println("Possible moves to " + currentField.getNeighbours());
            System.out.print("Choose a number from above: ");
            nextFieldNumber = input.nextInt();
        } else {
            nextFieldNumber = nextPossibleFields.get(0);
        }
        for (Field field : gameBoard.getAllFields()) {
            if(field.getFieldNumber() == nextFieldNumber) {
                nextField = field;
                break;
            }
        }
        return nextField;
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
     * Try to catch the victim.
     * A victim can be caught, if the attacker will finish his move on the victims field.
     * If the victim is located on a save field it's not possible to catch it.
     * @param field current field
     * @param attacker game piece that joins the field
     */
    private boolean catchTheVictim(Field field, Hat attacker, List<Hat> hats) {
        if(!isSaveField(field)) {
            Hat victim = null;
            for(Hat element : hats) {
                if(element.getHatPosition() == field.getFieldNumber()) {
                    victim = element;
                }
            }
            attacker.addVictim(victim);
            victim.setCaptured(true);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "{" +
                "  maxHats=" + getMaxHats() +
                ", playerCount=" + getPlayers() +
                '}';
    }

}
