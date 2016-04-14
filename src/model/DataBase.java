package model;

import model.*;
import model.Modelli.Data;
import model.Partecipante;
import util.generatoriCasuali.NumeroTraDue;

/**
 * Created by Chado on 14/04/2016.
 */
public class DataBase  {

    //@TODO finisci setup qui

    public static Maestro[] maestri = new Maestro[2];

    public static Corso[] corsi = new Corso[2];

    public DataBase() {
        maestri[0] = new Maestro("Paolo", "Barbarossa", "051-112233", new Data("6", "2", "1969"));
        corsi[0] = new Corso((maestri[0]), "Corso Facile", 50.35);

        System.out.println("Setup dati completato");

    }

    private String rndDay() {
        NumeroTraDue.extract()
    }
}
