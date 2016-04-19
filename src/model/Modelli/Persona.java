package model.Modelli;

/**
 * Creato da Vlady il 17/03/2016.
 * in origine parte del progetto:
 * CircoloTennis
 */
public class Persona {
private String nome, cognome;

public Persona(String nome, String cognome) {
	this.nome = nome;
	this.cognome = cognome;
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

public String getNomeCognome() {
	return nome + " " + cognome;
}
}
