package view.Partecipante_Modifica;

import Librerie.Util.UtilityMessages;
import model.Data.DataBase;
import model.Partecipante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JComboBox<String> tendinaCorso,tendinaPartecipante;
    private JPanel pnlCorso;
    private JPanel pnlPartecipante;
    private JPanel pnlTende;
    private JButton btnElimina;
    //    private int numeroConversioni=0;
    private JFrame localFrame;

    private int idCorsoSelezionato, idPartSelezionato;
    private Partecipante selezionato=null;

    private String[] partecipanti,corsi;

    public ScegliDaModificare(String title, int larghezza, int altezza) throws HeadlessException {
        super(title);
        this.pack();
        this.setSize(larghezza, altezza);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setContentPane(new ScegliDaModificare().rootPanel);

        DataBase.frameScegliDaModificare = this;
    }

    private ScegliDaModificare() {

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
        //quella partecipante si aggiorna da sola, lascio comunque commentato per sicurezza
        //settaTendinaPartecipante();


        DataBase.stampaDiagnostica();
    }

    private void settaTendinaCorso() {

        System.out.println("Selezionato in creazione: "+tendinaCorso.getSelectedIndex());
        tendinaCorso.removeAllItems();

        for (int i = 0; i < DataBase.getNomiCorsiConPartecipanti().size(); i++) {
            tendinaCorso.addItem(DataBase.getNomiCorsiConPartecipanti().get(i));
        }
    }

    private void settaTendinaPartecipante() {
        //reagisce al cambiamento di tendinaCorso

        tendinaPartecipante.removeAllItems();
        //così non metto doppioni

        aggiornaCorsoSelezionato();

        //riempio la tendinaPartecipante
        for (int i = 0; i < DataBase.getPartecipantiAlCorso(idCorsoSelezionato).size(); i++) {
            tendinaPartecipante.addItem(DataBase.getPartecipantiAlCorso(idCorsoSelezionato).get(i));
        }

        aggiornaPartecipanteSelezionato();

    }


    private void settaListener() {

        localFrame = this;
        //TODO - forse causa errore

        btnModifica.addActionListener(new ActionListener() {
            //listener
            @Override
            public void actionPerformed(ActionEvent e) {
                aggiornaPartecipanteSelezionato();


                //dispongo la finestra attuale
                //l'ordine dei prossimi 2 è importante
                DataBase.frameScegliDaModificare.dispose();


                apriFinestraModifica();
            }
        });
        btnElimina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminaPartecipante();
            }
        });
        tendinaCorso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settaTendinaPartecipante();
            }
        });
    }



    private void eliminaPartecipante() {

        aggiornaSelezionati();

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Vuoi davvero eliminare "
                        + selezionato.getNome()+" "
                        + selezionato.getCognome()+" ?"
                , "Elimina partecipante", dialogButton);

        if(dialogResult == 0) {

//            for (int i=0;i<50;i++) {
//
//                String tmp = getFrames()[i].getClass().getCanonicalName();
//
//                if (tmp.equals(this.getClass().getCanonicalName())) {
//                    System.out.println("Frame n:"+i);
//                    getFrames()[i].dispose();
//                    break;
//                }
//
//            }


            //dispongo la finestra attuale
            DataBase.frameScegliDaModificare.dispose();

            System.out.println("Utente sceglie SI");
            DataBase.getCorsi()[idCorsoSelezionato].remove(idPartSelezionato);

            String toMsg = selezionato.getNomeCognome() + " rimosso/a correttamente";

            UtilityMessages.creaDialogInfo(toMsg,this);

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

        selezionato = DataBase.getPartecipanteAlCorso(idCorsoSelezionato, idPartSelezionato);


        System.out.println("---Corso selezionato: "+ idCorsoSelezionato);
        System.out.println("--Indice selezionato: "+ idPartSelezionato);
        System.out.println(">Da editare:" +selezionato.getNome()+" "+selezionato.getCognome());
        System.out.println(
                "Nato il: "
                        +selezionato.getDataDiNascita().getGiorno()
                        +"-"
                        +selezionato.getDataDiNascita().getMese()
                        +"-"
                        +selezionato.getDataDiNascita().getAnno()
        );

    }

    private void apriFinestraModifica() {

        aggiornaSelezionati();

        ModificaPartecipante finestra = new ModificaPartecipante(" Modifica: " +
                selezionato.getNome() + " " + selezionato.getCognome()
                , DataBase.altezzaModifica, DataBase.larghezzaModifica
                , selezionato
                , idCorsoSelezionato
                , idPartSelezionato);
    }

    private void aggiornaCorsoSelezionato() {
        String[] nomiCorsi = DataBase.getNomiCorsi();

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
            UtilityMessages.creaDialogErrore("Non ci sono corsi con partecipanti",new Frame("Fine del mondo"));
        }
    }


}





