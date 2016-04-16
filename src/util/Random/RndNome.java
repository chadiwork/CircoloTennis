package util.Random;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Creato da Vlady il 14/04/2016.
 * in origine parte del progetto:
 * CircoloTennis
 */
public class RndNome {

    private static LinkedList<String> nomi;

    private static boolean isSetupEffettuato = false;

    private static String filePath = "./src/util/ListeAnagrafici/listaCognomi.txt";


    private static void setupList() throws FileNotFoundException {

        try {
            nomi=readLines(new File(filePath));

//            for (int i = 0; i >= nomi.size();i++) {
//                System.out.println(nomi.get(i));
//            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore");
        }
    }

    private static LinkedList<String> readLines(File file) throws Exception {
        if (!file.exists()) {
            return new LinkedList<String>();
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        LinkedList<String> results = new LinkedList<String>();
        String line = reader.readLine();
        while (line != null) {

            System.out.println(line);

            results.add(line);
            line = reader.readLine();
        }
        return results;
    }





    public static String get()  {

        //se la lista non è stata preparata allora la preparo
        if (!isSetupEffettuato) {
            try {
                setupList();
                isSetupEffettuato = true;
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

