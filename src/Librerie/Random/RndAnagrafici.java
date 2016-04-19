package Librerie.Random;

import Librerie.Util.UtilityFile;

import java.io.File;
import java.io.FileNotFoundException;
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

private static String fileNomi = "./src/Librerie/ListeAnagrafici/listaNomi.txt";
private static String fileCognomi = "./src/Librerie/ListeAnagrafici/listaCognomi.txt";


private static void setupListNomi() throws FileNotFoundException {

	try {
		nomi = UtilityFile.readLinesFromFile(new File(fileNomi));
		System.out.println("Setup list nomi effettuato correttamente");

	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Errore");
	}
}

private static void setupListCognomi() throws FileNotFoundException {

	try {
		cognomi = UtilityFile.readLinesFromFile(new File(fileCognomi));
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
		System.out.println("Errore setup completo - probabilmente file non trovato");
	}

}

public static String getRndNome() {
	controllaSetup();

	// Pick one at random
	int randomIndex = RndNmbrInRange.random(1, nomi.size() - 1);
	return nomi.get(randomIndex);
}

public static String getRndCognome() {
	controllaSetup();

	// Pick one at random
	int randomIndex = RndNmbrInRange.random(1, cognomi.size() - 1);
	return cognomi.get(randomIndex);
}

private static void controllaSetup() {
	//se la lista non è stata preparata allora la preparo
	//se non è stato fatto il setup
	if (!isSetupEffettuato) {
		isSetupEffettuato = true;
		setupCompleto();
	}
}


}

