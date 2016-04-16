package util.Random;

import util.Libs.UtilityFile;

import java.io.*;
import java.util.LinkedList;

/**
 * Creato da Vlady il 14/04/2016.
 * in origine parte del progetto:
 * CircoloTennis
 */
public class RndAnagrafici {

    private static LinkedList<String> nomi;
    private static LinkedList<String> cognomi;

    private static boolean isSetupEffettuato = false;

    private static String fileNomi = "./src/util/ListeAnagrafici/listaNomi.txt";
    private static String fileCognomi = "./src/util/ListeAnagrafici/listaCognomi.txt";


    private static void setupListNomi() throws FileNotFoundException {

        try {
            nomi= UtilityFile.readLines(new File(fileNomi));
            System.out.println("Setup list nomi effettuato correttamente");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore");
        }
    }

    private static void setupListCognomi() throws FileNotFoundException {

        try {
            cognomi= UtilityFile.readLines(new File(fileCognomi));
            System.out.println("Setup list cognomi effettuato correttamente");


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore");
        }
    }

    private static void setupCompleto() {
        try {
            setupListNomi();
            setupListCognomi();
            System.out.println("Setup completo fatto");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Errore setup completo");
        }

    }

    public static String getRndNome()  {
        //se la lista non è stata preparata allora la preparo
        if (!isSetupEffettuato) {
            setupCompleto();
            isSetupEffettuato = true;
        }

        // Pick one at random
        int randomIndex = RndNmbrInRange.random(1,nomi.size());
        return nomi.get(randomIndex);
    }

    public static String getRndCognome()  {
        //se la lista non è stata preparata allora la preparo
        if (!isSetupEffettuato) {
            setupCompleto();
            isSetupEffettuato = true;
        }

        // Pick one at random
        int randomIndex = RndNmbrInRange.random(1,cognomi.size());
        return cognomi.get(randomIndex);
    }




}

