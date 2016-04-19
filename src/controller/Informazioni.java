package controller;

import model.Data.D;
import model.Partecipante;

import javax.swing.*;

/**
 * Created by Chado on 01/04/2016.
 */
public class Informazioni extends JFrame {

JPanel rootPanel;
private JLabel lblTotale;
private JLabel lblMaestroMedio;
private JLabel lblNumeroFacile;
private JLabel lblMaestroFacile;
private JLabel lblNumeroMedio;
private JLabel lblMaestroAvanzato;
private JLabel lblNumeroAvanzato;
private JProgressBar progressBase;
private JProgressBar progressMedio;
private JProgressBar progressAvanzato;
private JTextArea areaMedi;
private JTextArea areaAvanzati;
private JTextArea areaBase;

private Informazioni() {
	//costruttore in cui aggiungere tutte le modifiche alla UI
	//tieni private

	settaLabelMaestri();

	riempiArea(0);
	riempiArea(1);
	riempiArea(2);

	settaLabelNumeroPartecipanti();



}

private void settaLabelNumeroPartecipanti() {


	String desc = "Partecipanti: ";

	lblNumeroFacile.setText(desc+String.valueOf(D.getPartecipantiAlCorso(0).size()));
	lblNumeroMedio.setText(desc+String.valueOf(D.getPartecipantiAlCorso(1).size()));
	lblNumeroAvanzato.setText(desc+String.valueOf(D.getPartecipantiAlCorso(2).size()));

}

private void riempiArea(int idArea) {

	int indiceIterazione=1;

	for (Partecipante p : D.getPartecipantiAlCorso(idArea)) {

		String toAppend = indiceIterazione+"- "+p.getNomeCognome() + ", " + p.getEtà() + " anni" + "\n";

		switch (idArea) {
			case 0:areaBase.append(toAppend);
				break;
			case 1:areaMedi.append(toAppend);
				break;
			case 2:areaAvanzati.append(toAppend);
		}

		indiceIterazione++;

	}

}

private void settaLabelMaestri() {

	String m = "Maestro: ";
	String a = " anni";

	lblMaestroFacile.setText(m+
			D.getMestroCorso(0).getNomeCognome()+
			", "+D.getMestroCorso(0).getEtà()+a
	);
	lblMaestroMedio.setText(m+
			D.getMestroCorso(1).getNomeCognome()+
			", "+D.getMestroCorso(1).getEtà()+a
	);

	lblMaestroAvanzato.setText(m+
			D.getMestroCorso(2).getNomeCognome()+
			", "+D.getMestroCorso(2).getEtà()+a
	);
}


Informazioni(String title, int larghezza, int altezza) {
	//setup iniziale finestra
	super(title);
	this.setContentPane(new Informazioni().rootPanel);
	this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	this.pack();
	this.setSize(larghezza, altezza);
	this.setLocationRelativeTo(null);
	this.setVisible(true);
	this.setResizable(true);
}
}
