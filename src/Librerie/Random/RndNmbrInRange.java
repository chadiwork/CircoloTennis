package Librerie.Random;

/**
 * Creato da Vlady il 14/04/2016.
 * in origine parte del progetto:
 * CircoloTennis
 */
import java.lang.*;
import java.util.Random;

public class RndNmbrInRange {

    public static int random(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("Il massimo deve essere maggiore del minimo");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}