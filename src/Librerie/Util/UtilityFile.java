package Librerie.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

/**
 * Creato da Vlady il 16/04/2016.
 * in origine parte del progetto:
 * CircoloTennis
 */
public class UtilityFile {

public static LinkedList<String> readLinesFromFile(File file) throws Exception {
	if (!file.exists()) {
		return new LinkedList<>();
	}
	BufferedReader reader = new BufferedReader(new FileReader(file));
	LinkedList<String> results = new LinkedList<>();
	String line = reader.readLine();
	while (line != null) {

		//scommentare la riga seguente per stampare riga per riga le stringhe in lettura
		//System.out.println(line);

		results.add(line);
		line = reader.readLine();
	}
	return results;
}
}
