package model.Modelli;

import Librerie.Random.RndNmbrInRange;

import java.util.Objects;

/**
 * Created by Chado on 17/03/2016.
 * and some magic by Vlady
 */
public class Data {
private String giorno, mese, anno;

public Data(String giorno, String mese, String anno) {
	this.giorno = giorno;
	this.mese = mese;
	this.anno = anno;
}

public Data() {
	//con costruttore vuoto aggiungo dati casuali
	this.mese = rndMonth();
	this.giorno = rndDay();
	this.rndYear();
}

public String getGiorno() {
	return giorno;
}

public void setGiorno(String giorno) {
	this.giorno = giorno;
}

public String getMese() {
	return mese;
}

public void setMese(String mese) {
	this.mese = mese;
}

public String getAnno() {
	return anno;
}

public void setAnno(String anno) {
	this.anno = anno;
}

private String rndDay() {
	//tiene conto di febbraio
	if (Objects.equals(this.mese, "2")) {
		Integer a = RndNmbrInRange.random(1, 28);
		return a.toString();
	} else {
		Integer a = RndNmbrInRange.random(1, 30);
		return a.toString();
	}

}

private String rndMonth() {
	Integer a = RndNmbrInRange.random(1, 12);
	return a.toString();
}

private String rndYear() {
	Integer a = RndNmbrInRange.random(1940, 2010);
	return a.toString();
}
}
