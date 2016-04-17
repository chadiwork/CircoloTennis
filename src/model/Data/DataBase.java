package model.Data;

import Librerie.Random.RndTelNumber;
import model.Corso;
import model.Maestro;
import model.Modelli.Data;
import model.Partecipante;
import Librerie.Util.UtilityString;
import Librerie.Random.RndAnagrafici;

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

    private static boolean isSetupFatto = false;

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
        maestri[0] = new Maestro(UtilityString.capFirst(RndAnagrafici.getRndNome()),
                UtilityString.capFirst(RndAnagrafici.getRndCognome()), RndTelNumber.conPrefisso(), new Data());
        maestri[1] = new Maestro(UtilityString.capFirst(RndAnagrafici.getRndNome()),
                UtilityString.capFirst(RndAnagrafici.getRndCognome()), RndTelNumber.conPrefisso(), new Data());
        maestri[2] = new Maestro(UtilityString.capFirst(RndAnagrafici.getRndNome()),
                UtilityString.capFirst(RndAnagrafici.getRndCognome()), RndTelNumber.conPrefisso(), new Data());



        //TODO - test
        System.out.println(RndTelNumber.conPrefisso());
    }

    public static void addPartecipante(int idCorso, Partecipante personaDaAggiungere) {
        controllaSetup();
        corsi[idCorso].add(personaDaAggiungere);

        System.out.println("Aggiunto: "+personaDaAggiungere.getNome());
    }

    private static void controllaSetup() {
        //se non è stato fatto il setup
        if (!isSetupFatto) {
            setupIniziale();
            isSetupFatto = true;
        }
    }

    public static String getNomeCorso(int idCorso) {
        controllaSetup();
        return corsi[idCorso].getNomeCorso();
    }

    public static Maestro getMestroCorso(int idCorso) {
        controllaSetup();
        return corsi[idCorso].getMaestro();
    }

    public static Integer getNumeroPartecipantiCorso(int idCorso) {
        controllaSetup();
        return corsi[idCorso].size();
    }

    public static String getNomeMaestroCorso(int idCorso) {
        controllaSetup();
        return corsi[idCorso].getMaestro().getNome();
    }

    public static boolean isAllEmpty() {
        controllaSetup();
        //controllo se sono tutti vuoti
        return isCorsoVuoto(0) && isCorsoVuoto(1) && isCorsoVuoto(2);
    }

    public static boolean isCorsoVuoto(int idCorso) {
        controllaSetup();
        //controllo se un corso in particolare è vuoto
        return corsi[idCorso].size() == 0;
    }


    public static String getCognomeMaestroCorso(int idCorso) {
        controllaSetup();
        return corsi[idCorso].getMaestro().getCognome();
    }
}
