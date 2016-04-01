package model;

import model.Modelli.Data;

/**
 * Created by Chado on 17/03/2016.
 */
public class Maestro extends Persona{

    String numTel;
    Data data;

    public Maestro(String nome, String cognome, String numTel, Data data) {
        super(nome, cognome);
        this.numTel = numTel;
        this.data = data;
    }
}
