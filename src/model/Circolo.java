package model;

import model.Modelli.Indirizzo;

import java.util.LinkedList;

/**
 * Created by Chado on 17/03/2016.
 */
public class Circolo extends LinkedList {
    String nome;
    Indirizzo indirizzo;
    Corso corso;

    public Circolo(String nome, Corso corso, Indirizzo indirizzo) {
        this.nome = nome;
        this.corso = corso;
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }
}
