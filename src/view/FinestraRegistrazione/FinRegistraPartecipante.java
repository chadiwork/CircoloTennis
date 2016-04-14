package view.FinestraRegistrazione;

import model.DataBase;
import model.Modelli.Data;
import model.Partecipante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    Frame mainFrame =new Frame();
    String[] tabellaCodici;


    public FinRegistraPartecipante(String title, int larghezza, int altezza) {
        //setup iniziale finestra
        super(title);
        settaStatoIniziale(larghezza, altezza);
    }

    private void settaStatoIniziale(int larghezza, int altezza) {
        this.setContentPane(new FinRegistraPartecipante().rootPanel);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(larghezza, altezza);
        this.setLocationRelativeTo(null);
        //this.setPosizioneCentro();
        this.setVisible(true);
        this.setResizable(false);



        onFirstOpening();

    }

    private void creaEtichetteTendina() {
        @SuppressWarnings("MismatchedReadAndWriteOfArray")

        String[] tabellaCodici =new String[3];

        tabellaCodici[3]="Scegliere il corso ";

        tabellaCodici[0]="Facile";
        tabellaCodici[1]="Medio";
        tabellaCodici[2]="Avanzato";

    }
    private void riempiTendina() {
        //aggiungo roba alla tendina
        for (int i = 0; i <= 3; i++) {
            tendinaCorso.addItem(tabellaCodici[i]);
        }
    }

    private void onFirstOpening() {
        txtAreaInseriti.setText("");


        //gestisco tendina
        creaEtichetteTendina();
        riempiTendina();
    }

    public FinRegistraPartecipante() {
        addListenerInserisci();
    }

    private void addListenerInserisci() {
        btnInserisciPartecipante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aggiungiPartecipante();
            }
        });
    }



    private void aggiungiPartecipante() {
        //if di controllo, vedo se l'utente immette info sensate e complete
        //eccezioni gestite
        if (tendinaCorso.getSelectedIndex() != 3) {

            int codicePaz = tendinaCorso.getSelectedIndex();

            if (!inputNome.getText().equals("")) {

                if (inputNome.getText().matches("[a-zA-Z]+")) {
                    String nome = inputNome.getText();

                    if (!inputCognome.getText().equals("")) {
                        if (inputCognome.getText().matches("[a-zA-Z]+")) {

                            String cognome = inputCognome.getText();
                            if (!inputGiorno.getText().equals("")) {
                                if (inputGiorno.getText().matches("^([0-9])\\w+")) {
                                    if (!inputMese.getText().equals("")) {
                                        if (inputMese.getText().matches("([0-9])\\w+")) {
                                            if (!inputAnno.getText().equals("")) {
                                                if (inputAnno.getText().matches("^([0-9])\\w+")) {

                                                    //raccolgo dati calendario
                                                    String giorno =inputGiorno.getText();
                                                    String mese =inputMese.getText();
                                                    String anno =inputMese.getText();

                                                    //ora ho tutti i dati raccolti
                                                    Partecipante toAdd = costruisciPartecipante(nome, cognome, giorno, mese, anno);

                                                    String tmpAppenaAggiuntoA="";//setup iniziale

                                                    //aggiungo partecipante al corso selezionato
                                                    switch (tendinaCorso.getSelectedIndex()) {
                                                        case 0:DataBase.corsi[0].add(toAdd);
                                                            tmpAppenaAggiuntoA = DataBase.corsi[0].getNome();
                                                            break;
                                                        case 1:DataBase.corsi[1].add(toAdd);
                                                            tmpAppenaAggiuntoA = DataBase.corsi[1].getNome();
                                                            break;
                                                        case 2:DataBase.corsi[2].add(toAdd);
                                                            tmpAppenaAggiuntoA = DataBase.corsi[2].getNome();
                                                            break;
                                                    }


                                                    svuotaCampi();

                                                    //stampo l'inserimento effettuato
                                                    txtAreaInseriti.append(toAdd.getCognome() +" aggiunto a corso "+tmpAppenaAggiuntoA+ "\n");

                                                    //partecipante creato e pronto

                                                }else {
                                                    creaDialogErrore("Inserisci una data corretta");
                                                }
                                            }else {
                                                creaDialogErrore("Inserisci una data");
                                            }
                                        }else {
                                            creaDialogErrore("Inserisci solo numeri interi nel mese,senza lo zero");
                                        }
                                    }else {
                                        creaDialogErrore("Inserisci un mese");
                                    }
                                } else {
                                    creaDialogErrore("Inserisci solo LETTERE nel nome");
                                }
                            } else {
                                creaDialogErrore("Inserisci il nome");
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
                creaDialogErrore("RndNome non inserito");
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
}
