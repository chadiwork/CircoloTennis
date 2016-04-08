package model;

import model.Modelli.Indirizzo;

import java.util.LinkedList;

/**
 * Created by Chado on 17/03/2016.
 */
public class Circolo extends LinkedList<Corso> {
    String nome;
    Indirizzo indirizzo;

    //circolo contiene vari corsi


    public Circolo(String nome, Indirizzo indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
    }
}
