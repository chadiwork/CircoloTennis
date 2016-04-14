package model;

/**
 * Created by Chado on 17/03/2016.
 */
public class Circolo {

    String nome;

    Corso[] corsi;

    //circolo contiene vari corsi


    public Circolo(String nome, Corso[] corsi) {
        this.nome = nome;
        this.corsi = corsi;
    }
}
