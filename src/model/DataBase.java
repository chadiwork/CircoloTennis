package model;

import model.Modelli.Data;
import util.Random.RndAnagrafici;

/**
 * Created by Chado on 14/04/2016.
 */
public class DataBase  {

    private static final double costoFacile = 50.35;
    private static final double costoMedio = 65.75;
    private static final double costoAvanzato = 90.99;

    private static String[] nomiCorsi = new String[3];

    private static Maestro[] maestri = new Maestro[3];

    private static Corso[] corsi = new Corso[3];

    private static boolean setupEffettuato=false;

    public DataBase() {
        setupIniziale();
    }

    private static void setupIniziale() {
        creaEtichetteNomi();
        creaMaestri();
        creaCorsi();


        System.out.println("Setup dati completato");
    }

    private static void creaEtichetteNomi() {
        nomiCorsi[0] = "Facile";
        nomiCorsi[1] = "Medio";
        nomiCorsi[2] = "Avanzato";
    }

    private static void creaCorsi() {
        corsi[0] = new Corso((maestri[0]), nomiCorsi[0], costoFacile);
        corsi[1] = new Corso((maestri[1]), nomiCorsi[1], costoMedio);
        corsi[2] = new Corso((maestri[2]), nomiCorsi[2], costoAvanzato);
    }

    private static void creaMaestri() {
        maestri[0] = new Maestro(capFirst(RndAnagrafici.getRndNome()), capFirst(RndAnagrafici.getRndCognome()), "025-112233", new Data());
        maestri[1] = new Maestro(capFirst(RndAnagrafici.getRndNome()), capFirst(RndAnagrafici.getRndCognome()), "011-425698", new Data());
        maestri[2] = new Maestro(capFirst(RndAnagrafici.getRndNome()), capFirst(RndAnagrafici.getRndCognome()), "051-124378", new Data());
    }

    public static void addPartecipante(int idCorso,Partecipante personaDaAggiungere) {
        //se non è stato fatto il setup
        if (!setupEffettuato) {
            setupIniziale();
            setupEffettuato = true;
        }
        corsi[idCorso].add(personaDaAggiungere);

        System.out.println(personaDaAggiungere.getNome()+ " aggiunto correttamente al database");

    }

    public static String getNomeCorso(int idCorso) {
        return corsi[idCorso].getNomeCorso();
    }

    public static Integer getNumeroPartecipantiCorso(int idCorso) {
        return corsi[idCorso].size();
    }

    public static String getNomeMaestroCorso(int idCorso) {

//        String str = corsi[idCorso].getMaestro().getNome();
//        String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
        // cap = "Java"

        return corsi[idCorso].getMaestro().getNome();
    }

    public static String capFirst(String toCap) {
        return toCap.substring(0, 1).toUpperCase() + toCap.substring(1);
    }


    public static String getCognomeMaestroCorso(int idCorso) {
        return corsi[idCorso].getMaestro().getCognome();
    }
}
