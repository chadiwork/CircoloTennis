package controller;

import model.Data.D;
import model.Modelli.Data;
import model.Partecipante;
import Librerie.Random.RndAnagrafici;

import javax.swing.*;
import java.awt.*;

import static Librerie.Random.RndNmbrInRange.*;
import static Librerie.Util.UtilityConstants.*;
import static Librerie.Util.UtilityMessages.*;
import static Librerie.Util.UtilityString.*;

/**
 * Created by Chado on 01/04/2016.
 * vlady però ha fatto tutto
 */
public class RegistraPartecipante extends JFrame {

    private JPanel rootPanel;
    private JPanel pnlCenter;
    private JPanel pnlForm;
    private JPanel pnlNomeCliente;
    private JPanel pnlGiorno;
    private JButton btnInserisciPartecipante;
    private JComboBox<String> tendinaCorso;
    private JPanel pnlCognomeCliente;
    private JPanel pnlStoria;
    private JTextArea txtAreaInseriti;
    private JTextField inputCognome;
    private JPanel pnlDate;
    private JPanel pnlMese;
    private JTextField inputMese;
    private JPanel pnlAnno;
    private JTextField inputAnno;
    private JTextField inputNome;
    private JTextField inputGiorno;
    private JLabel lblUltimoInserito;
    private JPanel pnlTendina;
    private JButton btnAddCasuale;
    private JButton btnRiempi;
    private JButton btnCompletaInserimenti;
    private JFormattedTextField formattedTextField1;
    private String[] tabellaCodici;
    private int indiceAncoraDaScegliere;


    private void onFirstOpening() {
        txtAreaInseriti.setText("");
        settaTendina();

    }

    private RegistraPartecipante() {
        //costruttore in cui aggiungere tutte le modifiche alla UI
        //tieni private
        addListener();
        onFirstOpening();

    }

    private void aggiungiPartecipante() {
        //if di controllo, vedo se l'utente immette info sensate e complete
        //eccezioni gestite

        if (tendinaCorso.getSelectedIndex() != indiceAncoraDaScegliere) {

            int codicePaz = tendinaCorso.getSelectedIndex();

            if (!inputNome.getText().equals("")) {
                if (inputNome.getText().matches(regexParole)) {

                    String nome = inputNome.getText();

                    if (!inputCognome.getText().equals("")) {
                        if (inputCognome.getText().matches(regexParole)) {

                            String cognome = inputCognome.getText();

                            if (!inputGiorno.getText().equals("")) {
                                if (inputGiorno.getText().matches(regexNumeri)
                                        && (Integer.parseInt(inputGiorno.getText()) <= 31)
                                        && (Integer.parseInt(inputGiorno.getText()) >= 1)) {

                                    String giorno =inputGiorno.getText();

                                    if (!inputMese.getText().equals("")) {
                                        if (inputMese.getText().matches(regexNumeri)
                                                && (Integer.parseInt(inputMese.getText()) <= 12)
                                                && (Integer.parseInt(inputMese.getText()) >= 1)) {

                                            String mese =inputMese.getText();

                                            if (!inputAnno.getText().equals("")) {
                                                if (inputAnno.getText().matches(regexNumeri)
//                                                        &&Integer.parseInt(inputMese.getText())<=2016
//                                                        &&Integer.parseInt(inputMese.getText())>=1900
                                                        ) {

                                                    String anno =inputAnno.getText();

                                                    //ora ho tutti i dati raccolti

                                                    Partecipante toAdd = costruisciPartecipante(nome, cognome, giorno, mese, anno);
                                                    //partecipante creato e pronto
                                                    String tmpAppenaAggiuntoA="";//setup iniziale

                                                    //riprendo l'indice del corso selezionato
                                                    int idSelezionato = tendinaCorso.getSelectedIndex();

                                                    //aggiungo partecipante al corso selezionato
                                                    switch (tendinaCorso.getSelectedIndex()) {
                                                        case 0:
                                                            D.addPartecipante(0,toAdd);
//                                                            tmpAppenaAggiuntoA = D.getNomeCorso(0);
                                                            break;
                                                        case 1:
                                                            D.addPartecipante(1,toAdd);
//                                                            tmpAppenaAggiuntoA = D.getNomeCorso(1);
                                                            break;
                                                        case 2:
                                                            D.addPartecipante(2,toAdd);
//                                                            tmpAppenaAggiuntoA = D.getNomeCorso(2);
                                                            break;
                                                    }

                                                    //nome del corso al quale ho appena aggiunto il partecipante
                                                    tmpAppenaAggiuntoA = D.getNomeCorso(idSelezionato);

                                                    svuotaCampi();

                                                    //numero di compagni del partecipante in aggiunta di quel corso
                                                    int compagniCorso = D.getNumeroPartecipantiCorso(idSelezionato) - 1;

                                                    //stampo l'inserimento effettuato
                                                    txtAreaInseriti.append(toAdd.getNome() +" aggiunto a corso "+tmpAppenaAggiuntoA+ "\n");
                                                    txtAreaInseriti.append("Compagni: "+compagniCorso + "\n");

                                                    //aggiorno label
                                                    lblUltimoInserito.setText(
                                                            "Maestro: " + D.getNomeMaestroCorso(idSelezionato)
                                                            + " " + D.getCognomeMaestroCorso(idSelezionato) +" | "+
                                                            "Tel: " + D.getMestroCorso(idSelezionato).getNumTel()
                                                    );

                                                }else {
                                                    creaDialogErrore("Inserisci un anno correttamente", this);
                                                }
                                            }else {
                                                creaDialogErrore("Inserisci l'anno", this);
                                            }
                                        }else {
                                            creaDialogErrore("Inserisci solo numeri interi nel mese,senza lo zero", this);
                                        }
                                    }else {
                                        creaDialogErrore("Inserisci il mese", this);
                                    }
                                } else {
                                    creaDialogErrore("Inserisci un numero tra 1 e 31 nel campo giorno", this);
                                }
                            } else {
                                creaDialogErrore("Devi inserire il giorno", this);
                            }
                        } else {
                            creaDialogErrore("Inserisci solo LETTERE nel cognome", this);
                        }
                    } else {
                        creaDialogErrore("Cognome non inserito", this);
                    }
                } else {
                    creaDialogErrore("Inserisci solo LETTERE nel nome", this);
                }
            } else {
                creaDialogErrore("Nome non inserito", this);
            }
        } else {
            creaDialogErrore("Non hai selezionato il corso a cui aggiungere il partecipante ", this);
        }
    }

    private void svuotaCampi() {
        //svuoto robe
        svuotaJText(inputAnno);
        svuotaJText(inputGiorno);
        svuotaJText(inputMese);
        svuotaJText(inputCognome);
        svuotaJText(inputNome);

        //rimetto tendina da impostare
        tendinaCorso.setSelectedIndex(3);
    }

    private Partecipante costruisciPartecipante(String nome, String cognome, String giorno, String mese, String anno) {
        Data dataNascita = new Data(giorno, mese, anno);
        return new Partecipante(nome, cognome, dataNascita);
    }

    private void svuotaJText(JTextField daSvuotare) {
        daSvuotare.setText("");
    }

    public RegistraPartecipante(String title, int larghezza, int altezza) {
        //setup iniziale finestra
        super(title);
        this.setContentPane(new RegistraPartecipante().rootPanel);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.pack();
        this.setSize(larghezza, altezza);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    private void addListener() {

        btnInserisciPartecipante.addActionListener(evt -> aggiungiPartecipante());

        btnAddCasuale.addActionListener(evt -> riempiCampiInRandom());

        btnCompletaInserimenti.addActionListener(evt->D.chiudiFinestra(D.getkRegistra()));

        btnRiempi.addActionListener(evt -> aggiungiNCasuali(20));
    }

    private void aggiungiNCasuali(int numeroPartecipanti) {
        for (int i = 0; i < numeroPartecipanti; i++) {
            riempiCampiInRandom();
            aggiungiPartecipante();
        }
    }

    private void riempiCampiInRandom() {
        //riempio i campi con valori casuali
        inputNome.setText(capFirst(RndAnagrafici.getRndNome()));
        inputCognome.setText(capFirst(RndAnagrafici.getRndCognome()));
        tendinaCorso.setSelectedIndex(random(1,3)-1);
        inputGiorno.setText(""+ random(1, 31));
        inputMese.setText(""+ random(1, 12));
        inputAnno.setText(""+ random(1920, 2016));
    }

    private void settaTendina() {
        String[] tabellaCodici =new String[4];

        tabellaCodici[0]="Facile";
        tabellaCodici[1]="Medio";
        tabellaCodici[2]="Avanzato";
        tabellaCodici[3]="Scegliere...";

        //non separare questi 2 blocchi in 2 metodi separati...
        for (int i =0;i<=3;i++){
            tendinaCorso.addItem(tabellaCodici[i]);
            indiceAncoraDaScegliere = i;
        }

        tendinaCorso.setSelectedIndex(indiceAncoraDaScegliere);
    }

}
