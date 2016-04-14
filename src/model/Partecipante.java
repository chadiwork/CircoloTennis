package model;

import model.Modelli.Data;
import model.Modelli.Persona;

/**
 * Created by Chado on 17/03/2016.
 * ^vlady too..
 */
public class Partecipante extends Persona {

    Data dataDiNascita;

    public Partecipante(String nome, String cognome, Data dataDiNascita) {
        super(nome, cognome);
        this.dataDiNascita = dataDiNascita;
    }

    //creati getter e setter per modificare o prendere dati del tipo @Indirizzo e @Data

    public Data getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Data dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

}

