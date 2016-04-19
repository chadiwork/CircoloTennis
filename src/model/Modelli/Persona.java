package model.Modelli;

/**
 * Creato da Vlady il 17/03/2016.
 * in origine parte del progetto:
 * CircoloTennis
 */
public class Persona {
private String nome, cognome;
private Data dataDiNascita;

public Persona(String nome, String cognome, Data dataDiNascita) {
	this.nome = nome;
	this.cognome = cognome;
	this.dataDiNascita = dataDiNascita;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCognome() {
	return cognome;
}

public void setCognome(String cognome) {
	this.cognome = cognome;
}

public Data getDataDiNascita() {
	return dataDiNascita;
}

public void setDataDiNascita(Data dataDiNascita) {
	this.dataDiNascita = dataDiNascita;
}

public String getNomeCognome() {
	return this.getNome() + " " + this.getCognome();
}

public int getEtà() {
	return 2016 - Integer.parseInt(this.dataDiNascita.getAnno());
}
}
