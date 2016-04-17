package view.Partecipante_Modifica;

import Librerie.Util.UtilityMessages;
import model.Data.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static model.Data.DataBase.getCorsi;

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
    private JComboBox tendinaCorso;
    private JComboBox tendinaPartecipante;
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
//        if (!DataBase.isCorsoVuoto(0)) {
//
//
//            for (int i = 0; i <= DataBase.getCorsi()[0].size(); i++) {
//                partecipanti = new String[DataBase.getCorsi()[0].size()];
//
//                partecipanti[i]=(DataBase.getCorsi()[0].get(i).getNome());
//
//                System.out.println(partecipanti[i]);
//                //aggiungere qui se vuoi anche il cognome
//            }
//        }

        DataBase.stampaDiagnostica();
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
    }


}





