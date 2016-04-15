package util.Random;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Creato da Vlady il 14/04/2016.
 * in origine parte del progetto:
 * CircoloTennis
 */
public class RndNome {

    private static LinkedList<String> nomi;

    private static boolean isSetupEffettuato = false;

    private static void setupList() throws FileNotFoundException {

//        // Open the file
//        File file = new File("./src/util/ListeAnagrafici/listaNomi.txt");
//
//        // Attach a scanner to the file
//        Scanner localScanner = new Scanner(file);
//
//        // Read the nomi from the file
//        nomi = new LinkedList<>();
//        while (localScanner.hasNextLine()) {
//            nomi.add(localScanner.next());
//        }
//        System.out.println("La dimensione della lista è: "+nomi.size());

        String fileName = "./src/util/ListeAnagrafici/listaNomi.txt";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }




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

