package model.Data;

import Librerie.Random.RndTelNumber;
import model.Corso;
import model.Maestro;
import model.Modelli.Data;
import model.Partecipante;
import Librerie.Util.UtilityString;
import Librerie.Random.RndAnagrafici;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Chado on 14/04/2016.
 */
public class DataBase  {

    //costanti finestra
    private static final int kMain =0;
    private static final int kRegistra =1;
    private static final int kScegli =2;
    private static final int kModifica =3;

    public static int getkMain() {
        return kMain;
    }

    public static int getkRegistra() {
        return kRegistra;
    }

    public static int getkScegli() {
        return kScegli;
    }

    public static int getkModifica() {
        return kModifica;
    }
    //frame:
    //0- main
    //1- registra
    //2- scegli modifica
    //3- modifica
    //4-

    private static ArrayList<Frame>finestre;

    //finestraModifica
    //    public static Frame frameModifica;
    public static final int altezzaModifica =400;
    public static final int larghezzaModifica = 300;

    //ScegliDaModificare
    //    public static Frame frameScegliDaModificare;
    public static final int altezzaScegliModifica =400;
    public static final int larghezzaScegliModifica = 300;

    //utilizzata al posto di circolo

    private static final double costoFacile = 50.35;
    private static final double costoMedio = 65.75;
    private static final double costoAvanzato = 90.99;

    private static String[] nomiCorsi = new String[3];

    private static Maestro[] maestri = new Maestro[3];

    private static Corso[] corsi = new Corso[3];

    private static boolean isSetupFatto = false;

    //frame finestra

    public DataBase() {
        setupIniziale();
    }

    private static void setupIniziale() {
        creaEtichetteNomi();
        creaMaestri();
        creaCorsi();
        //l'ordine è importantissimo qui, non cambiarlo
        System.out.println("Setup dati completato");
    }

    private static void creaEtichetteNomi() {
        nomiCorsi[0] = "Facile";
        nomiCorsi[1] = "Medio";
        nomiCorsi[2] = "Avanzato";
        System.out.println("Etichette costruite");
    }

    private static void creaCorsi() {
        corsi[0] = new Corso((maestri[0]), nomiCorsi[0], costoFacile);
        corsi[1] = new Corso((maestri[1]), nomiCorsi[1], costoMedio);
        corsi[2] = new Corso((maestri[2]), nomiCorsi[2], costoAvanzato);
        System.out.println("Corsi costruiti");
    }

    private static void creaMaestri() {
        //luogo dove costruisco i maestri
        maestri[0] = new Maestro(UtilityString.capFirst(RndAnagrafici.getRndNome()),
                UtilityString.capFirst(RndAnagrafici.getRndCognome()), RndTelNumber.conPrefisso(), new Data());
        maestri[1] = new Maestro(UtilityString.capFirst(RndAnagrafici.getRndNome()),
                UtilityString.capFirst(RndAnagrafici.getRndCognome()), RndTelNumber.conPrefisso(), new Data());
        maestri[2] = new Maestro(UtilityString.capFirst(RndAnagrafici.getRndNome()),
                UtilityString.capFirst(RndAnagrafici.getRndCognome()), RndTelNumber.conPrefisso(), new Data());
        System.out.println("Mestri costruiti");
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

    @NotNull
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
        return isCorsoVuoto(0)
                &&isCorsoVuoto(1)
                &&isCorsoVuoto(2);
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

    public static Corso[] getCorsi() {
        return corsi;
    }

    public static String[] getNomiCorsi() {
        return nomiCorsi;
    }

    public static Maestro[] getMaestri() {
        return maestri;
    }

    public static void stampaDiagnostica() {

        controllaSetup();

        String[] partecipanti;

        System.out.println(">>>>Diagnostica:");

        int totali=0;

        System.out.println("Size 0:"+corsi[0].size());
        System.out.println("Size 1:"+corsi[1].size());
        System.out.println("Size 2:"+corsi[2].size());

        for (int f=0;f<3;f++) {

            System.out.println("--Indice corso:"+f);

            if (!getCorsi()[f].isEmpty()) {

                partecipanti = new String[getCorsi()[f].size()+1];

                for (int i = 0; i < getCorsi()[f].size(); i++) {

                    System.out.println("-Indice partecipante:"+i);

                    partecipanti[i]=(getCorsi()[f].get(i).getNome());

                    System.out.println("Partecipante: "+partecipanti[i]);

                    totali++;

                    //aggiungere qui se vuoi anche il cognome
                }
            }
            System.out.println("---");
            System.out.println("Totali contati per ora:"+totali);
            System.out.println("Totali size:"+getNumeroTotali());
            System.out.println("---");
        }

    }

    public static int getNumeroTotali() {
        return corsi[0].size()+
                corsi[1].size()+
                corsi[2].size();
    }

    public static String[] estraiPartecipantiInseriti(int idCorso) {

        controllaSetup();

        int dim = corsi[idCorso].size();

        String[] partecipanti = null;

        if (dim > 0) {


            partecipanti = new String[dim];

            for (int i = 0; i < dim; i++) {

                String nome = corsi[idCorso].get(i).getNome();
                String cognome = corsi[idCorso].get(i).getCognome();

                partecipanti[i] = nome + " " + cognome;

            }

        }

        return partecipanti;
    }

    public static LinkedList<String> getPartecipantiAlCorso(int idCorso) {

        LinkedList<String> tmp=new LinkedList<String>();

        for (int i = 0; i < corsi[idCorso].size(); i++) {
            tmp.add(corsi[idCorso].get(i).getNome()+
                    " "+
                    corsi[idCorso].get(i).getCognome()

            );
        }

        return tmp;

    }

    public static ArrayList<String> getNomiCorsiConPartecipanti() {

        ArrayList<String> tmp = new ArrayList<>();

//        String[] corsiConPartecipanti = null;

        for (int f=0;f<3;f++) {

            if (!getCorsi()[f].isEmpty()) {

                tmp.add(nomiCorsi[f]);
            }
        }

        return tmp;
    }

    public static Partecipante getPartecipanteAlCorso(int idCorso,int idPartecipante) {
        return corsi[idCorso].get(idPartecipante);
    }

    public static void setPartecipanteAlCorso(int idCorso,int idPosizione,Partecipante nuovoPartecipante) {
        corsi[idCorso].set(idPosizione,nuovoPartecipante);
    }

    public static void rimuoviPartecipanteDaCorso(int idCorso,int idPosizione) {
        corsi[idCorso].remove(idPosizione);
    }


    public static void chiudiFinestra(int indice) {
        //frame:
        //0- main
        //1- registra
        //2- scegli modifica
        //3- modifica
        //4-
        finestre.get(indice).dispose();
        finestre.set(indice,null) ;
    }

    public static void assegnaFinestra(int indice,Frame frame) {

        //inizializza la lista
        inizializzaLaLista();

//        if (finestre.get(indice) == null) {
        finestre.set(indice, frame);
//        }else finestre.add(indice, frame);
        //l'else in teoria non si applica mai
    }

    private static void inizializzaLaLista() {
        if (finestre == null) {

            finestre = new ArrayList<>();

            for (int i=0;i<10;i++) {
                finestre.add(null);
            }
        }
    }

    public static Frame getFinestra(int indice) {
        inizializzaLaLista();
        return finestre.get(indice);
    }

    public static boolean isFinestraAperta(int indice) {
        inizializzaLaLista();
//        return finestre.get(indice);
        return getFinestra(indice) != null;
    }
}


