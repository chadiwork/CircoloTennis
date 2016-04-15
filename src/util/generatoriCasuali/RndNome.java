package util.generatoriCasuali;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Creato da Vlady il 14/04/2016.
 * in origine parte del progetto:
 * CircoloTennis
 */
public class RndNome {

    static LinkedList<String> nomi;

    static boolean isSetupEffettuato = false;

    private static void setupList() throws FileNotFoundException {

        // Open the file
        File file = new File("listaNomi.txt");

        // Attach a scanner to the file
        Scanner localScanner = new Scanner(file);

        // Read the nomi from the file
        nomi = new LinkedList<>();
        while (localScanner.hasNext()) {
            nomi.add(localScanner.next());
        }
        System.out.println("La dimensione della lista è: "+nomi.size());

    }

    public static String get()  {

        //se la lista non è stata preparata allora la preparo
        if (!isSetupEffettuato) {
            try {
                setupList();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "Default";
            }
        }


//        if (nomi.size() < 0) {
//            setupList();
//        }
//        //se la lista non è stata preparata allora la preparo
//        if (nomi.size() < 0) {
//            try {
//                setupList();
//            } catch (FileNotFoundException e) {
////                e.printStackTrace();
//                System.out.println("Errore di lettura del file dei nomi");
//                return "Default";
//                //in caso di errore i nomi saranno tutti default, gestisco l'errore qui
//            }
//        }

        // Pick one at random
        int randomIndex = RndNmbrInRange.random(1,nomi.size());

        return nomi.get(randomIndex);

    }


}
