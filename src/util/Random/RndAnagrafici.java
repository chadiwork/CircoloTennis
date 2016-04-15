package util.Random;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Chado on 11/02/2016.
 * Classe per leggere e generare nomi e cognomi casuali
 */
public class RndAnagrafici {
    private static String[] nome;
    private static String[] cognome;
    private static File fileNomi = new File("Nomi.txt");
    private static File fileCognomi = new File("Cognomi.txt");
    private static Scanner lettoreFileNomi;
    private static Scanner lettoreFileCognomi;


    private static void setupIniziale() throws FileNotFoundException{
        //TODO Controllare le refernces
        lettoreFileNomi=new Scanner(fileNomi);
        lettoreFileCognomi=new Scanner(fileCognomi);
        nome=new String[8913];
        cognome=new String[170];
    }
    private static  void leggiNomi(){
        //leggo il file finchè c'è una stringa e incremento l'array
        int i=0;
        while (lettoreFileNomi.hasNext()){
            String tmp=lettoreFileNomi.next(); //String temporanea
            nome[i]=tmp.substring(0, 1).toUpperCase() + tmp.substring(1); //Mette maiuscole ai nomi
            i++;
        }

        lettoreFileNomi.close();
    }
    private static void leggiCognomi(){
        //leggo il file finchè c'è una stringa e incremento l'array
        int i=0;
        while (lettoreFileCognomi.hasNext()){
            String tmp=lettoreFileCognomi.next(); //String temporanea
            cognome[i]= tmp.substring(0, 1).toUpperCase() + tmp.substring(1); //Mette maiuscole ai nomi

            i++;
        }
        lettoreFileCognomi.close();
    }
    //Restituisce un intero casuale
    private static int indiceCasuale(int Low, int High){
        Random r=new Random();
        return r.nextInt(High-Low)+Low;
    }
    public static String[] getNome() {
        return nome;
    }

    public static String[] getCognome() {
        return cognome;
    }
}
