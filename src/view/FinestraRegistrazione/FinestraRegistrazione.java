package view.FinestraRegistrazione;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Chado on 01/04/2016.
 */
public class FinestraRegistrazione extends JFrame {

    private JPanel rootPanel;
    private JPanel pnlCenter;
    private JPanel pnlForm;
    private JPanel pnlNomeCliente;
    private JPanel pnlGiorno;
    private JButton btnMettiInSala;
    private JComboBox comboCorso;
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

    public FinestraRegistrazione(String title, int larghezza, int altezza) {
        //setup iniziale finestra
        super(title);
        this.setContentPane(new FinestraRegistrazione().rootPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(larghezza, altezza);
        this.setLocationRelativeTo(null);
        //this.setPosizioneCentro();
        this.setVisible(true);
        this.setResizable(false);
    }
    public FinestraRegistrazione() {


//        private void inserimentiForm() {

//            controllaEstetica_Pulizia();

        //if di controllo, vedo se l'utente immette info sensate e complete
        //eccezioni gestite
        if (comboCorso.getSelectedIndex() != 4) {

            int codicePaz = comboCorso.getSelectedIndex();

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
                creaDialogErrore("Nome non inserito");
            }
        } else {
            creaDialogErrore("Non hai selezionato la priorità del paziente");
        }

    }

    private void creaDialogErrore(String message) {
        JOptionPane.showMessageDialog(mainFrame,
                message,
                "Errore",
                JOptionPane.WARNING_MESSAGE);
    }
}
