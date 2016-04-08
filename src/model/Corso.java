package model;

import java.util.LinkedList;

/**
 * Created by Chado on 17/03/2016.
 */
public class Corso extends LinkedList<Partecipante>{

    Maestro maestro;
    String nome;
    double costo;

    //classe pronta
    //corso contiene vari partecipanti

    public Corso(Maestro maestro, String nome, double costo) {
        this.maestro = maestro;
        this.nome = nome;
        this.costo = costo;
    }

    public void aggiungiPartecipante(Partecipante partInAggiunta){
        this.add(partInAggiunta);
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public String getNome() {
        return nome;
    }

    public double getCosto() {
        return costo;
    }
}
