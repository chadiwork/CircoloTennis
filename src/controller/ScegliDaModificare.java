package controller;

import Librerie.Util.UtilityMessages;
import model.Data.D;
import model.Partecipante;

import javax.swing.*;
import java.awt.*;

/**
 * Creato da Vlady il 15/01/2016.
 * in origine parte del progetto:
 * PilaProjYakovenko
 */
public class ScegliDaModificare extends JFrame {

    private JPanel rootPanel;
    private JButton btnModifica;
    private JPanel pnlCenter;
    private JPanel pnlModifica;
    private JComboBox<String> tendinaCorso, tendinaPartecipante;
    private JPanel pnlCorso;
    private JPanel pnlPartecipante;
    private JPanel pnlTende;
    private JButton btnElimina;
    //    private int numeroConversioni=0;
    private JFrame localFrame;

    private int idCorsoSelezionato, idPartSelezionato;
    private Partecipante selezionato = null;

    private String[] partecipanti, corsi;

    public ScegliDaModificare(String title, int larghezza, int altezza) throws HeadlessException {
        super(title);
        this.setContentPane(new ScegliDaModificare().rootPanel);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.pack();
        this.setSize(larghezza, altezza);
        this.setVisible(true);
        this.setPosizioneCentro();


//        D.assegnaFinestra(D.getkScegli(),this);
    }

    private ScegliDaModificare() {

        if (D.isAllEmpty()) {
            UtilityMessages.creaDialogErrore("I corsi sono tutti vuoti! ", new Frame("Errore"));
            System.exit(50000);
        } else {
            settaListener();
            settaTendine();
        }

//        aggiungiListenerChiusura();

    }

    private void settaTendine() {

        settaTendinaCorso();
        //quella partecipante si aggiorna da sola, lascio comunque commentato per sicurezza
        //settaTendinaPartecipante();


        D.stampaDiagnostica();
    }

    private void settaTendinaCorso() {

        System.out.println("Selezionato in creazione: " + tendinaCorso.getSelectedIndex());
        tendinaCorso.removeAllItems();

        for (int i = 0; i < D.getNomiCorsiConPartecipanti().size(); i++) {
            tendinaCorso.addItem(D.getNomiCorsiConPartecipanti().get(i));
        }
    }

    private void settaTendinaPartecipante() {
        //reagisce al cambiamento di tendinaCorso

        tendinaPartecipante.removeAllItems();
        //così non metto doppioni

        aggiornaCorsoSelezionato();

        //riempio la tendinaPartecipante
        for (int i = 0; i < D.getNominativiPartecipantiAlCorso(idCorsoSelezionato).size(); i++) {
            int n = i + 1;
            tendinaPartecipante.addItem(n + "- " + D.getNominativiPartecipantiAlCorso(idCorsoSelezionato).get(i));
        }

        aggiornaPartecipanteSelezionato();

    }


    private void settaListener() {

        btnModifica.addActionListener(evt -> {
            aggiornaPartecipanteSelezionato();

            //dispongo la finestra attuale
            //l'ordine dei prossimi 2 è importante
            D.chiudiFinestra(D.getkScegli());
            apriFinestraModifica();
        });

        btnElimina.addActionListener(evt -> eliminaPartecipante());

        tendinaCorso.addActionListener(evt -> settaTendinaPartecipante());

    }

    private void eliminaPartecipante() {

        aggiornaSelezionati();

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Vuoi davvero eliminare "
                        + selezionato.getNome() + " "
                        + selezionato.getCognome() + " ?"
                , "Elimina partecipante", dialogButton);

        if (dialogResult == 0) {

            //dispongo la finestra attuale
            D.chiudiFinestra(D.getkScegli());

            System.out.println("Utente sceglie SI");
            D.getCorsi()[idCorsoSelezionato].remove(idPartSelezionato);

            String toMsg = selezionato.getNomeCognome() + " rimosso/a correttamente";

            UtilityMessages.creaDialogInfo(toMsg, this);

            System.out.println("Funziona ancora e va avanti");


        } else {
            System.out.println("Utente sceglie NO");
        }

    }

    private void aggiornaSelezionati() {
        aggiornaCorsoSelezionato();
        aggiornaPartecipanteSelezionato();
    }

    private void aggiornaPartecipanteSelezionato() {
        idPartSelezionato = tendinaPartecipante.getSelectedIndex();

        selezionato = D.getPartecipanteAlCorso(idCorsoSelezionato, idPartSelezionato);


        System.out.println("---Corso selezionato: " + idCorsoSelezionato);
        System.out.println("--Indice selezionato: " + idPartSelezionato);
        System.out.println(">Da editare:" + selezionato.getNome() + " " + selezionato.getCognome());
        System.out.println(
                "Nato il: "
                        + selezionato.getDataDiNascita().getGiorno()
                        + "-"
                        + selezionato.getDataDiNascita().getMese()
                        + "-"
                        + selezionato.getDataDiNascita().getAnno()
        );

    }

    private void apriFinestraModifica() {

        aggiornaSelezionati();

        D.assegnaFinestra(D.getkModifica(),
                new ModificaPartecipante(" Modifica: " +
                        selezionato.getNome() + " " + selezionato.getCognome()
                        , D.altezzaModifica, D.larghezzaModifica
                        , selezionato
                        , idCorsoSelezionato
                        , idPartSelezionato)
        );
    }

    private void aggiornaCorsoSelezionato() {
        String[] nomiCorsi = D.getNomiCorsi();

        //switch paurosi
        if (tendinaCorso.getSelectedItem().equals(nomiCorsi[0])) {
            //caso corso facile
            idCorsoSelezionato = 0;
        } else if (tendinaCorso.getSelectedItem().equals(nomiCorsi[1])) {
            //caso corso medio
            idCorsoSelezionato = 1;
        } else if (tendinaCorso.getSelectedItem().equals(nomiCorsi[2])) {
            //caso corso avanzato
            idCorsoSelezionato = 2;
        } else {
            UtilityMessages.creaDialogErrore("Non ci sono corsi con partecipanti", new Frame("Fine del mondo"));
        }
    }


    //TODO - crea listener onchiusura ripulisci i frame s db


    private void setPosizioneCentro() {
        // valuta le dimensioni della finestra
        int larg;
        int alt;
        alt = this.getHeight();
        larg = this.getWidth();
        // serve per la risoluzione dello schermo
        final Toolkit kit = Toolkit.getDefaultToolkit();
        final Dimension dimensione = kit.getScreenSize();
        final int x = dimensione.width / 2 - larg / 2;
        final int y = dimensione.height / 2 - alt / 2;
        this.setLocation(x, y);
    }


}





