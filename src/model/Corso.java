package model;

/**
 * Created by Chado on 17/03/2016.
 */
public class Corso {
    Partepante partepante;
    Maestro maestro;
    String nome;
    double costo;

    public Corso(Partepante partepante, String nome, double costo, Maestro maestro) {
        this.partepante = partepante;
        this.nome = nome;
        this.costo = costo;
        this.maestro = maestro;
    }

    public Partepante getPartepante() {
        return partepante;
    }

    public void setPartepante(Partepante partepante) {
        this.partepante = partepante;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
