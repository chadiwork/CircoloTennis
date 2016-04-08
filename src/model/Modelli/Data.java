package model.Modelli;

/**
 * Created by Chado on 17/03/2016.
 */
public class Data {
    String giorno,mese,anno;

    public Data(String giorno, String mese, String anno) {
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
    }

    public void setMese(String mese) {
        this.mese = mese;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getGiorno() {
        return giorno;
    }

    public String getMese() {
        return mese;
    }

    public String getAnno() {
        return anno;
    }
}
