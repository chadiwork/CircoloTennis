package model;

import model.Modelli.Data;
import model.Modelli.Indirizzo;

/**
 * Created by Chado on 17/03/2016.
 */
public class Partecipante extends Persona{

    Indirizzo mIndirizzo;
    
    Data dataDiNascita;


    public Partecipante(String nome, String cognome, Indirizzo mIndirizzo, Data dataDiNascita) {
        super(nome, cognome);
        this.mIndirizzo = mIndirizzo;
        this.dataDiNascita = dataDiNascita;
    }
}

