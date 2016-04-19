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
private JLabel lblFacile;
private JLabel lblMaestroFacile;
private JLabel lblMedio;
private JLabel lblMaestroAvanzato;
private JLabel lblAvanzato;
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
	lblMaestroFacile.setText("Maestro: "+
			D.getMestroCorso(0).getNomeCognome()+
			", "+D.getMestroCorso(0).getEtà()+" anni"
	);
	lblMaestroMedio.setText("Maestro: "+
			D.getMestroCorso(1).getNomeCognome()+
			", "+D.getMestroCorso(1).getEtà()+" anni"
	);

	lblMaestroAvanzato.setText("Maestro: "+
			D.getMestroCorso(2).getNomeCognome()+
			", "+D.getMestroCorso(2).getEtà()+" anni"
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
