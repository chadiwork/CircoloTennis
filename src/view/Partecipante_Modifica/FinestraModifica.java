package view.Partecipante_Modifica;

import Librerie.Util.UtilityMessages;
import model.Data.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Creato da Vlady il 15/01/2016.
 * in origine parte del progetto:
 * PilaProjYakovenko
 */
public class FinestraModifica extends JFrame {

    private JPanel rootPanel;
    private JButton btnModifica;
    private JPanel pnlCenter;
    private JPanel pnlModifica;
    private JComboBox<String> tendinaCorso;
    private JComboBox<String> tendinaPartecipante;
    private JPanel pnlCorso;
    private JPanel pnlPartecipante;
    private JPanel pnlTende;
    private JButton btnElimina;
//    private int numeroConversioni=0;

    private String[] partecipanti;
    private String[] corsi;

    public FinestraModifica(String title, int larghezza, int altezza) throws HeadlessException {
        super(title);
        this.setContentPane(new FinestraModifica().rootPanel);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(larghezza, altezza);
        this.setVisible(true);
    }

    private FinestraModifica() {

        if (DataBase.isAllEmpty()) {
            UtilityMessages.creaDialogErrore("I corsi sono tutti vuoti! ", new Frame("Errore"));
            System.exit(50000);
        } else {
            settaListener();
            settaTendine();
        }



    }

    private void settaTendine() {

        settaTendinaCorso();
//        settaTendinaPartecipante();


        DataBase.stampaDiagnostica();
    }

    private void settaTendinaCorso() {

        for (int i = 0; i < DataBase.getNomiCorsiConPartecipanti().size(); i++) {
            tendinaCorso.addItem(DataBase.getNomiCorsiConPartecipanti().get(i));
        }

    }

    private void settaTendinaPartecipante() {

        String[] nomiCorsi = DataBase.getNomiCorsi();

        if (tendinaCorso.getSelectedItem().equals(nomiCorsi[0])) {
            //caso corso facile

            for (int i = 0; i < DataBase.getPartecipantiAlCorso(0).size(); i++) {
                tendinaPartecipante.addItem(DataBase.getPartecipantiAlCorso(0).get(i));
            }

        } else if (tendinaCorso.getSelectedItem().equals(nomiCorsi[1])) {
            //caso corso medio
            for (int i = 0; i < DataBase.getPartecipantiAlCorso(1).size(); i++) {
                tendinaPartecipante.addItem(DataBase.getPartecipantiAlCorso(1).get(i));
            }

        } else if (tendinaCorso.getSelectedItem().equals(nomiCorsi[2])) {
            //caso corso avanzato
            for (int i = 0; i < DataBase.getPartecipantiAlCorso(2).size(); i++) {
                tendinaPartecipante.addItem(DataBase.getPartecipantiAlCorso(2).get(i));
            }

        }

    }



    private void settaListener() {
        btnModifica.addActionListener(new ActionListener() {
            //listener
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("OK");
            }
        });

        btnElimina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        tendinaCorso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settaTendinaPartecipante();
            }
        });
    }





}





