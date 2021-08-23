package object;

import java.util.Random;

public class Dice {
    final static int maxEyes = 6;

    private static int throwDice() {
        Random rn = new Random();
        return rn.nextInt(maxEyes);
    }
}
