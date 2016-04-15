package view.FinestraRegistrazione;

import model.DataBase;
import model.Modelli.Data;
import model.Partecipante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Chado on 01/04/2016.
 * vlady però ha fatto tutto
 */
public class FinRegistraPartecipante extends JFrame {

    private JPanel rootPanel;
    private JPanel pnlCenter;
    private JPanel pnlForm;
    private JPanel pnlNomeCliente;
    private JPanel pnlGiorno;
    private JButton btnInserisciPartecipante;
    private JComboBox<String> tendinaCorso;
    private JPanel pnlCognomeCliente;
    private JPanel pnlStoria1;
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
    private JFormattedTextField formattedTextField1;
    Frame mainFrame = new Frame();
    private String[] tabellaCodici;
    private int indiceAncoraDaScegliere;

    String regexParole="[a-zA-Z]+";
    String regexNumeri="[0-9]+";




    private void onFirstOpening() {
        txtAreaInseriti.setText("");

        settaTendina();


    }

    private FinRegistraPartecipante() {
        //costruttore in cui aggiungere tutte le modifiche alla UI
        //tieni private
        addListenerInserisci();
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
                                        &&Integer.parseInt(inputGiorno.getText())<=31
                                        &&Integer.parseInt(inputGiorno.getText())>=1 ) {

                                    String giorno =inputGiorno.getText();

                                    if (!inputMese.getText().equals("")) {
                                        if (inputMese.getText().matches(regexNumeri)
                                                &&Integer.parseInt(inputMese.getText())<=12
                                                &&Integer.parseInt(inputMese.getText())>=1) {

                                            String mese =inputMese.getText();

                                            if (!inputAnno.getText().equals("")) {
                                                if (inputAnno.getText().matches(regexNumeri)
                                                        &&Integer.parseInt(inputMese.getText())<=2016
                                                        &&Integer.parseInt(inputMese.getText())>=1900) {

                                                    String anno =inputMese.getText();

                                                    //ora ho tutti i dati raccolti
                                                    Partecipante toAdd = costruisciPartecipante(nome, cognome, giorno, mese, anno);

                                                    String tmpAppenaAggiuntoA="";//setup iniziale

                                                    //aggiungo partecipante al corso selezionato
                                                    switch (tendinaCorso.getSelectedIndex()) {
                                                        case 0:DataBase.addPartecipante(0,toAdd);
                                                            tmpAppenaAggiuntoA = DataBase.getNomeCorso(0);
                                                            break;
                                                        case 1:DataBase.addPartecipante(1,toAdd);
                                                            tmpAppenaAggiuntoA = DataBase.getNomeCorso(1);
                                                            break;
                                                        case 2:DataBase.addPartecipante(2,toAdd);
                                                            tmpAppenaAggiuntoA = DataBase.getNomeCorso(2);
                                                            break;
                                                    }



                                                    svuotaCampi();

                                                    //stampo l'inserimento effettuato
                                                    txtAreaInseriti.append(toAdd.getCognome() +" aggiunto a corso "+tmpAppenaAggiuntoA+ "\n");

                                                    //partecipante creato e pronto

                                                }else {
                                                    creaDialogErrore("Inserisci un anno correttamente");
                                                }
                                            }else {
                                                creaDialogErrore("Inserisci l'anno");
                                            }
                                        }else {
                                            creaDialogErrore("Inserisci solo numeri interi nel mese,senza lo zero");
                                        }
                                    }else {
                                        creaDialogErrore("Inserisci il mese");
                                    }
                                } else {
                                    creaDialogErrore("Inserisci un numero tra 1 e 31 nel campo giorno");
                                }
                            } else {
                                creaDialogErrore("Devi inserire il giorno");
                            }
                        } else {
                            creaDialogErrore("Inserisci solo LETTERE nel cognome");
                        }
                    } else {
                        creaDialogErrore("Cognome non inserito");
                    }
                } else {
                    creaDialogErrore("Inserisci solo LETTERE nel nome");
                }
            } else {
                creaDialogErrore("Nome non inserito");
            }
        } else {
            creaDialogErrore("Non hai selezionato il corso a cui aggiungere il partecipante ");
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
        tendinaCorso.setSelectedIndex(4);
    }

    private Partecipante costruisciPartecipante(String nome, String cognome, String giorno, String mese, String anno) {
        Data dataNascita = new Data(giorno, mese, anno);
        return new Partecipante(nome, cognome, dataNascita);
    }

    private void creaDialogErrore(String message) {
        JOptionPane.showMessageDialog(mainFrame,
                message,
                "Errore",
                JOptionPane.WARNING_MESSAGE);
    }

    private void svuotaJText(JTextField daSvuotare) {
        daSvuotare.setText("");
    }

    public FinRegistraPartecipante(String title, int larghezza, int altezza) {
        //setup iniziale finestra
        super(title);
        this.setContentPane(new FinRegistraPartecipante().rootPanel);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(larghezza, altezza);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

    }

    private void addListenerInserisci() {
        btnInserisciPartecipante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aggiungiPartecipante();
            }
        });
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
