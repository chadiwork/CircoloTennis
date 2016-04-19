package controller;

import Librerie.Util.UtilityMessages;
import model.Data.D;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Chado on 01/04/2016.
 * suck it chadi
 */
public class FinestraMain extends JFrame {
private JPanel rootPanel;
private JPanel pnlCenter;
private JPanel pnlSX; //cambiare nome
private JButton visualizzaInformazioniDelCorsoButton;
private JButton btnRegistra;
private JButton btnScegliModifica;
private JButton visualizzaIncassoButton;


private FinestraMain(String title, int larghezza, int altezza) {
	//setup iniziale finestra
	super(title);
	this.setContentPane(new FinestraMain().rootPanel);
	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	this.pack();
	this.setSize(larghezza, altezza);
	this.setLocationRelativeTo(null);
	this.setVisible(true);
	this.setResizable(false);
}

private FinestraMain() {
	settaListenerTastiFinestre();
//        Circolo mainCircolo = new Circolo();
}

public static void main(String[] args) throws Exception {
	//main
	FinestraMain f = new FinestraMain("Circolo Tennis di Chadivlady", 450, 200);
}

public static void apriModifica() {

}

private void settaListenerTastiFinestre() {
	btnRegistra.addActionListener(e -> {
		apriFinestra(D.getkRegistra());
	});

	btnScegliModifica.addActionListener(e -> {
		apriFinestra(D.getkScegli());
	});

	visualizzaInformazioniDelCorsoButton.addActionListener(e -> {
		FinestraInfoCorso finestra = new FinestraInfoCorso();
		finestra.setVisible(true);
	});

	visualizzaIncassoButton.addActionListener(e -> {
		FinestraIncasso finestra = new FinestraIncasso();
		finestra.setVisible(true);
	});
}

private void apriFinestra(int indice) {

	int idFinRegistra = D.getkRegistra();
	int idFinScegli = D.getkScegli();

	//in base all'indice datomi dal listener faccio aprire ogni finestra solo una volta
	if (indice == idFinRegistra) {
		//if registra
		if (!D.isFinestraAperta(indice)) {

			D.assegnaFinestra(idFinRegistra,
					new RegistraPartecipante("Registra Partecipante",
							900,
							400)
			);
		}
	} else if (indice == idFinScegli) {
		if (!D.isFinestraAperta(indice)) {
			if (D.isAllEmpty()) {
				UtilityMessages.creaDialogErrore("I corsi sono tutti vuoti! ", new Frame("Errore"));
			} else {

				D.assegnaFinestra(
						idFinScegli,
						new ScegliDaModificare(
								"Modifica un partecipante",
								D.larghezzaScegliMod,
								D.altezzaScegliMod)
				);
			}
		}
	}
}

}

