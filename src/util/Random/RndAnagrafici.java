package util.Random;

import util.Libs.FileUtils;

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

    private static boolean isSetupNomiEffettuato = false;
    private static boolean isSetupCognomiEffettuato = false;

    private static String fileNomi = "./src/util/ListeAnagrafici/listaNomi.txt";
    private static String fileCognomi = "./src/util/ListeAnagrafici/listaCognomi.txt";


    private static void setupListNomi() throws FileNotFoundException {

        try {
            nomi= FileUtils.readLines(new File(fileNomi));
            System.out.println("Setup list nomi effettuato correttamente");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore");
        }
    }

    private static void setupListCognomi() {

        try {
            cognomi= FileUtils.readLines(new File(fileCognomi));
            System.out.println("Setup list cognomi effettuato correttamente");


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore");
        }
    }

    public static String getRndNome()  {
        //se la lista non è stata preparata allora la preparo
        if (!isSetupNomiEffettuato) {
            try {
                setupListNomi();
                isSetupNomiEffettuato = true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "Default";
            }
        }
        // Pick one at random
        int randomIndex = RndNmbrInRange.random(1,nomi.size());
        return nomi.get(randomIndex);
    }

    public static String getRndCognome()  {
        //se la lista non è stata preparata allora la preparo
        if (!isSetupCognomiEffettuato) {
            setupListCognomi();
            isSetupCognomiEffettuato = true;
        }
        // Pick one at random
        int randomIndex = RndNmbrInRange.random(1,cognomi.size());
        return cognomi.get(randomIndex);
    }




}

