package model;

import model.Modelli.Data;
import model.Modelli.Persona;

/**
 * Creato da Vlady il 17/03/2016.
 * in origine parte del progetto:
 * CircoloTennis
 */
public class Maestro extends Persona {

private String numTel;
private Data dataDiNascita;

public Maestro(String nome, String cognome, String numTel, Data data) {
	super(nome, cognome);
	this.numTel = numTel;
	this.dataDiNascita = data;
}

public Data getDataDiNascita() {
	return dataDiNascita;
}

public String getNumTel() {
	return numTel;
}
}
