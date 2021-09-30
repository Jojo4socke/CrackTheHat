package gameBoard.field;

import java.util.ArrayList;
import java.util.Set;

/**
 * A field on the game board.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-08-23
 */
public class Field {
    // Parameters
    /**
     * @param fieldNumber unique field number
     */
    private final int fieldNumber;
    /**
     * @param neighbours the fields neighbours
     */
    private ArrayList<Integer> neighbours;

    // Constructors
    /**
     * Constructor to create a normal field.
     * @param fieldNumber unique field number on game board
     */
    public Field(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    // Methods
    /**
     * Getter for fieldNumer.
     * @return unique field number
     */
    public int getFieldNumber() {
        return fieldNumber;
    }

    /**
     * Getter for the fields neighbours.
     * @return list of neighbours
     */
    public ArrayList<Integer> getNeighbours() {
        return neighbours;
    }

    /**
     * Set the neighbours for 2-4 player mode.
     */
    public void setNeighbours4P() {
        this.neighbours = calculatePreviousNextField4P();
        addMoreSourroundingFields4P();
    }

    /**
     * Calculate neighbours.
     * --> 2-4 player game mode
     */
    private ArrayList<Integer> calculatePreviousNextField4P() {
        ArrayList<Integer> sourroundingFields = null;
        if((fieldNumber > 0 && fieldNumber < 51)
                || (fieldNumber > 52 && fieldNumber < 58)
                || (fieldNumber > 59 && fieldNumber < 64)
                || (fieldNumber > 65 && fieldNumber < 70)
                || (fieldNumber > 71 && fieldNumber < 76)) {
            sourroundingFields.add(fieldNumber + 1);
            sourroundingFields.add(fieldNumber - 1);
        }
        if(fieldNumber == 0
                || fieldNumber == 52
                || fieldNumber == 59
                || fieldNumber == 65
                || fieldNumber == 71) {
            sourroundingFields.add(fieldNumber + 1);

        }
        if(fieldNumber == 51
                || fieldNumber == 58
                || fieldNumber == 64
                || fieldNumber == 70
                || fieldNumber == 76) {
            sourroundingFields.add(fieldNumber - 1);
        }
        return sourroundingFields;
    }

    /**
     * Add neighbours for crossings etc.
     * --> 2-4 player game mode
     */
    private void addMoreSourroundingFields4P() {
        switch(fieldNumber) {
            case 0:
                neighbours.add(51);
                neighbours.add(58);
                neighbours.add(77);
                break;
            case 13:
                neighbours.add(64);
                neighbours.add(78);
                break;
            case 26:
                neighbours.add(70);
                neighbours.add(79);
                break;
            case 39:
                neighbours.add(76);
                neighbours.add(80);
                break;
            case 51:
            case 58:
            case 77:
                neighbours.add(0);
                break;
            case 52:
                neighbours.add(53);
                neighbours.add(59);
                neighbours.add(65);
                neighbours.add(71);
                break;
            case 64:
            case 78:
                neighbours.add(13);
                break;
            case 70:
            case 79:
                neighbours.add(26);
                break;
            case 76:
                neighbours.add(39);
                break;
            case 80:
                neighbours.add(39);
                break;
            default: break;
        }
    }

}
