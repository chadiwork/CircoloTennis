package view.FinestraMain;

import Librerie.Util.UtilityMessages;
import model.Data.DataBase;
import view.FinestraIncasso.FinestraIncasso;
import view.FinestraInfoCorso.FinestraInfoCorso;
import view.Partecipante_Modifica.ScegliDaModificare;
import view.Partecipante_Registrazione.RegistraPartecipante;

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


    public FinestraMain(String title, int larghezza, int altezza) {
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

    private void settaListenerTastiFinestre() {
        btnRegistra.addActionListener(e -> {
            apriFinestra(DataBase.getkRegistra());
        });

        btnScegliModifica.addActionListener(e -> {
            apriFinestra(DataBase.getkScegli());
        });

        visualizzaInformazioniDelCorsoButton.addActionListener(e -> {
            FinestraInfoCorso finestra=new FinestraInfoCorso();
            finestra.setVisible(true);
        });

        visualizzaIncassoButton.addActionListener(e -> {
            FinestraIncasso finestra=new FinestraIncasso();
            finestra.setVisible(true);
        });
    }

    public static void main(String[] args) throws Exception {
        //main
        FinestraMain f = new FinestraMain("Circolo Tennis di Chadivlady", 450, 200);
    }

    private void apriFinestra(int indice) {

//        if(finestraAperta())

        int uno,due,tre,quattro;
        uno = DataBase.getkRegistra();
        due = DataBase.getkScegli();


        //in base all'indice datomi dal listener faccio aprire ogni finestra solo una volta
        if (indice == DataBase.getkRegistra()) {
            //if registra
            if (!DataBase.isFinestraAperta(indice)) {

                DataBase.assegnaFinestra(DataBase.getkRegistra(),
                        new RegistraPartecipante("Registra Partecipante",
                                900,
                                400)
                );
//                finRegistraPartecipante.setVisible(true);
            }
        } else if (indice == DataBase.getkScegli()) {
            if (!DataBase.isFinestraAperta(indice)) {
                if (DataBase.isAllEmpty()) {
                    UtilityMessages.creaDialogErrore("I corsi sono tutti vuoti! ", new Frame("Errore"));
                } else {

                    DataBase.assegnaFinestra(
                            DataBase.getkScegli(),
                            new ScegliDaModificare(
                                    "Modifica un partecipante",
                                    DataBase.altezzaScegliModifica,
                                    DataBase.larghezzaScegliModifica)
                    );


//                    finestra.setVisible(true);
                }
            }
        }





    }



}

