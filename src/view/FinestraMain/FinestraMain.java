package view.FinestraMain;

import view.FinestraIncasso.FinestraIncasso;
import view.FinestraInfoCorso.FinestraInfoCorso;
import view.Partecipante_Modifica.FinModificaPartecipante;
import view.Partecipante_Modifica.FinestraModifica;
import view.Partecipante_Registra.FinRegistraPartecipante;

import javax.swing.*;

/**
 * Created by Chado on 01/04/2016.
 * suck it chadi
 */
public class FinestraMain extends JFrame {
    private JPanel rootPanel;
    private JPanel pnlCenter;
    private JPanel pnlSX; //cambiare nome
    private JButton visualizzaInformazioniDelCorsoButton;
    private JButton registraPartecipantiButton;
    private JButton modificaPartecipantiButton;
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
        registraPartecipantiButton.addActionListener(e -> {
            FinRegistraPartecipante finRegistraPartecipante =new FinRegistraPartecipante("Registra Partecipante",900,400);
            finRegistraPartecipante.setVisible(true);

        });

        modificaPartecipantiButton.addActionListener(e -> {
            FinestraModifica finestra=new FinestraModifica();
            finestra.setVisible(true);
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
}

