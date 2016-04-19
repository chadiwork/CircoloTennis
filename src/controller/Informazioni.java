package controller;

import model.Data.D;

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

	lblMaestroFacile.setText("Maestro: "+
			D.getMestroCorso(0).getNomeCognome()+
			" , "+D.getMestroCorso(0).getEtà()+" anni"

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
