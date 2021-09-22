package object;

import java.util.Random;

/**
 * A normal dice with six sides.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-08-23
 */
public class Dice {
    // Parameters
    /**
     * @param maxEyes number of sides of the dice
     */
    final static int maxEyes = 6;

    final static int minEyes = 1;

    // Methods
    /**
     * Throws the dice.
     * @return random number between 1 and 6.
     */
    private static int throwDice() {
        Random rn = new Random();
        return rn.nextInt(maxEyes + 1 - minEyes) + minEyes;
    }
}
