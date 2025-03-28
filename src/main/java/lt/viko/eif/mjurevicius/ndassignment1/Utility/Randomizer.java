package lt.viko.eif.mjurevicius.ndassignment1.Utility;

import java.util.Random;

public class Randomizer {
    private static Random rand = new Random();
    public static int randomInt (int min, int max) {
        if (min > max) {
            return  min;
        }
        else {
            return rand.nextInt((max - min) + 1) + min;
        }
    }
    public static int randomInt (int max) {
        if (max > 0) {
            return rand.nextInt(max + 1);
        } else return 0;
    }
}
