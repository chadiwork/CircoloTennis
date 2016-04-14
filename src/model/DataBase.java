package model;

import model.Modelli.Data;
import util.generatoriCasuali.RndNome;

/**
 * Created by Chado on 14/04/2016.
 */
public class DataBase  {

    public static String[] nomiCorsi = new String[2];

    public static Maestro[] maestri = new Maestro[2];

    public static Corso[] corsi = new Corso[2];

    public DataBase() {
        creaMaestri();
        creaCorsi();
        creaEtichetteNomi();

        System.out.println("Setup dati completato");

    }

    private void creaEtichetteNomi() {
        nomiCorsi[0] = "Facile";
        nomiCorsi[1] = "Medio";
        nomiCorsi[2] = "Avanzato";
    }

    private void creaCorsi() {
        corsi[0] = new Corso((maestri[0]), nomiCorsi[0], 50.35);
        corsi[1] = new Corso((maestri[1]), nomiCorsi[1], 65.75);
        corsi[2] = new Corso((maestri[2]), nomiCorsi[2], 90.99);
    }

    private void creaMaestri() {
        maestri[0] = new Maestro(RndNome.getRandomName(), "Barbarossa", "025-112233", new Data());
        maestri[1] = new Maestro(RndNome.getRandomName(), "Minelli", "011-425698", new Data());
        maestri[2] = new Maestro(RndNome.getRandomName(), "Bortolotti", "051-124378", new Data());
    }
}
