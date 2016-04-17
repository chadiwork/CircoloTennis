package Librerie.Random;

/**
 * Creato da Vlady il 17/04/2016.
 * in origine parte del progetto:
 * CircoloTennis
 */
public class RndTelNumber {

    public static String conPrefisso() {
        return ""+prefissoItalia() + numero();
    }

    public static String prefissoItalia() {
        return "0"+
                RndNmbrInRange.random(1, 9) +
                RndNmbrInRange.random(0, 9)+"-";
    }

    public static String numero() {
        return ""+
                RndNmbrInRange.random(0, 9) +
                RndNmbrInRange.random(0, 9) +
                RndNmbrInRange.random(0, 9) +
                RndNmbrInRange.random(0, 9) +
                RndNmbrInRange.random(0, 9) +
                RndNmbrInRange.random(0, 9);
    }
}
