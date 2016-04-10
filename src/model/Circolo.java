package model;

import model.Modelli.Indirizzo;

/**
 * Created by Chado on 17/03/2016.
 */
public class Circolo {

    String nome;
    Indirizzo indirizzo;

    Corso[] corsi;

    //circolo contiene vari corsi


    public Circolo(String nome, Indirizzo indirizzo, Corso[] corsi) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.corsi = corsi;
    }
}
