package model;

import model.Modelli.Data;
import model.Modelli.Indirizzo;
/**
 * Created by Chado on 17/03/2016.
 * ^vlady too..
 */
public class Partecipante extends Persona{


    Indirizzo mIndirizzo;
    
    Data dataDiNascita;


    public Partecipante(String nome, String cognome, Indirizzo mIndirizzo, Data dataDiNascita) {
        super(nome, cognome);
        this.mIndirizzo = mIndirizzo;
        this.dataDiNascita = dataDiNascita;
    }

    //creati getter e setter per modificare o prendere dati del tipo @Indirizzo e @Data

    public Data getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Data dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Indirizzo getmIndirizzo() {
        return mIndirizzo;
    }

    public void setmIndirizzo(Indirizzo mIndirizzo) {
        this.mIndirizzo = mIndirizzo;
    }
}

