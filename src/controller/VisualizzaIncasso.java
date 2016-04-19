package controller;

import model.Data.D;

import javax.swing.*;

/**
 * Created by Chado on 01/04/2016.
 */
public class VisualizzaIncasso extends JFrame {

private JPanel rootPanel;
private JLabel lblFacile;
private JLabel lblMedio;
private JLabel lblAvanzato;
private JLabel lblTotale;
private JLabel lblInfoFacile;
private JLabel lblInfoMedio;
private JLabel lblInfoAvanzato;
private JLabel lblInfoTotale;


private VisualizzaIncasso() {
	//costruttore in cui aggiungere tutte le modifiche alla UI
	//tieni private

	settaValoriGuadagni();

	lblInfoFacile.setText("Su "+String.valueOf(D.getNumeroPartecipantiCorso(0))+" partecipanti");
	lblInfoMedio.setText("Su "+String.valueOf(D.getNumeroPartecipantiCorso(1))+" partecipanti");
	lblInfoAvanzato.setText("Su "+String.valueOf(D.getNumeroPartecipantiCorso(2))+" partecipanti");


	lblInfoTotale.setText("Sul totale di "+
			String.valueOf(
					D.getNumeroPartecipantiCorso(0)+
							D.getNumeroPartecipantiCorso(1)+
							D.getNumeroPartecipantiCorso(2))
			+" partecipanti");

}

private void settaValoriGuadagni() {
	lblFacile.setText(String.valueOf(D.getGuadagno(0))+D.getValuta());
	lblMedio.setText(String.valueOf(D.getGuadagno(1))+D.getValuta());
	lblAvanzato.setText(String.valueOf(D.getGuadagno(2))+D.getValuta());

	lblTotale.setText(String.valueOf(D.getGuadagniTotali())+D.getValuta());
}

VisualizzaIncasso(String title, int larghezza, int altezza) {
	//setup iniziale finestra
	super(title);
	this.setContentPane(new VisualizzaIncasso().rootPanel);
	this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	this.pack();
	this.setSize(larghezza, altezza);
	this.setLocationRelativeTo(null);
	this.setVisible(true);
	this.setResizable(false);
}

}
