package controller;

import Librerie.Util.UtilityMessages;
import model.Data.D;
import model.Modelli.Data;
import model.Partecipante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Librerie.Util.UtilityConstants.regexNumeri;
import static Librerie.Util.UtilityConstants.regexParole;
import static Librerie.Util.UtilityMessages.creaDialogErrore;

/**
 * Created by Chado on 01/04/2016.
 * vlady però ha fatto tutto
 */
public class ModificaPartecipante extends JFrame {

    private JPanel rootPanel;
    private JPanel pnlCenter;
    private JPanel pnlForm;
    private JPanel pnlNomeCliente;
    private JPanel pnlGiorno;
    private JButton btnSalvaModifiche;
    private JComboBox<String> tendinaCorso;
    private JPanel pnlCognomeCliente;
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
    private JCheckBox checkCambia;
    private JPanel pnlCheck;
    private JPanel pnlTendinaNetta;
    private JButton btnAddCasuale;
    private String[] tabellaCodici;
    private int indiceAncoraDaScegliere;

    private int oldCorso, oldPosizione;
    private Partecipante oldPartecipante;


    private void onFirstOpening() {
        settaTendina();

        assegnaDaModificare();

        tendinaCorso.setSelectedIndex(3);

        //setto condizioni iniziali della tendina disabilitata

        tendinaCorso.setEnabled(false);

    }

    private void assegnaDaModificare() {

        System.out.println(oldPartecipante.getNome());
        inputNome.setText(oldPartecipante.getNome());
        inputCognome.setText(oldPartecipante.getCognome());
        inputGiorno.setText(oldPartecipante.getDataDiNascita().getGiorno());
        inputMese.setText(oldPartecipante.getDataDiNascita().getMese());
        inputAnno.setText(oldPartecipante.getDataDiNascita().getAnno());

        tendinaCorso.setSelectedIndex(oldCorso);
    }

    private ModificaPartecipante(Partecipante partecipante  ,int idCorso,int idPosizione) {
        //costruttore in cui aggiungere tutte le modifiche alla UI
        //tieni private

        //mi passo i valori
        this.oldPartecipante = partecipante;

//        System.out.println(oldPartecipante);
        this.oldCorso = idCorso;
        this.oldPosizione = idPosizione;

        addListener();
        onFirstOpening();

    }


    private void salvaModifiche() {
        //if di controllo, vedo se l'utente immette info sensate e complete
        //eccezioni gestite

        //codice pressochè uguale ad aggiungi partecipante nella come controlli

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

//                                                    //aggiungo partecipante al corso selezionato
//                                                    switch (tendinaCorso.getSelectedIndex()) {
//                                                        case 0:D.addPartecipante(0,toAdd);
//                                                            break;
//                                                        case 1:D.addPartecipante(1,toAdd);
//                                                            break;
//                                                        case 2:D.addPartecipante(2,toAdd);
//                                                            break;
//                                                    }


                                                    int dialogButton = JOptionPane.YES_NO_OPTION;
                                                    int dialogResult = JOptionPane.showConfirmDialog(this, "Stai per salvare: "
                                                                    + toAdd.getNome()+" "
                                                                    + toAdd.getCognome()+" | Confermi?"
                                                            , "Aggiorna dati partecipante", dialogButton);

                                                    if(dialogResult == 0) {

                                                        //creo diramificazione - se il corso è lo stesso modifica se è diverso cancella e aggiungi

                                                        boolean cambiaCorso = checkCambia.isSelected();

                                                        //controllo se sta mentendo, cioè se dice che non cambia corso
                                                        //ma in realtà lo cambia me ne accorgo e non sbaglio
                                                        if (tendinaCorso.isEnabled() && (oldCorso == tendinaCorso.getSelectedIndex())) {
                                                            cambiaCorso = false;
                                                        }

                                                        //effettivamente lavoro in base a ciò che so
                                                        if (!cambiaCorso) {
                                                            //aggiorna l'oggetto, in posizione nuova
                                                            D.setPartecipanteAlCorso(oldCorso, oldPosizione, toAdd);
                                                        } else if (cambiaCorso) {
                                                            //cancello vecchio partecipante
                                                            D.rimuoviPartecipanteDaCorso(oldCorso,oldPosizione);

                                                            //aggiungo nuovo con dati presi
                                                            D.addPartecipante(tendinaCorso.getSelectedIndex(),toAdd);
                                                        }

//                                                        D.frameModifica.dispose();

                                                        //TODO - in work
                                                        D.chiudiFinestra(D.getkModifica());

                                                        UtilityMessages.creaDialogInfo("Dati partecipante aggiornati correttamente",this);
                                                    }
//
//                                                    //nome del corso al quale ho appena aggiunto il partecipante
//                                                    //nome del corso al quale ho appena aggiunto il partecipante
//                                                    tmpAppenaAggiuntoA = D.getNomeCorso(idSelezionato);
//
//                                                    svuotaCampi();
//
//                                                    //numero di compagni del partecipante in aggiunta di quel corso
//                                                    int compagniCorso = D.getNumeroPartecipantiCorso(idSelezionato) - 1;
//
//                                                    //stampo l'inserimento effettuato
//                                                    txtAreaInseriti.append(toAdd.getNome() +" aggiunto a corso "+tmpAppenaAggiuntoA+ "\n");
//                                                    txtAreaInseriti.append("Compagni: "+compagniCorso + "\n");
//
//                                                    //aggiorno label
//                                                    lblUltimoInserito.setText(
//                                                            "Maestro: " + D.getNomeMaestroCorso(idSelezionato)
//                                                            + " " + D.getCognomeMaestroCorso(idSelezionato) +" | "+
//                                                            "Tel: " + D.getMestroCorso(idSelezionato).getNumTel()
//                                                    );



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

    private Partecipante costruisciPartecipante(String nome, String cognome, String giorno, String mese, String anno) {
        Data dataNascita = new Data(giorno, mese, anno);
        return new Partecipante(nome, cognome, dataNascita);
    }

    private void svuotaJText(JTextField daSvuotare) {
        daSvuotare.setText("");
    }

    public ModificaPartecipante(String title, int larghezza, int altezza,
                                Partecipante partecipante,int idCorso,int idPosizione) {
        super(title);

        //setup iniziale finestra
        this.setContentPane(new ModificaPartecipante(partecipante,idCorso,idPosizione).rootPanel);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(larghezza, altezza);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }
    private void addListener() {
        btnSalvaModifiche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvaModifiche();
            }
        });
        checkCambia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listenerCheckBox();
            }
        });
    }

    private void listenerCheckBox() {
        //flip flop
        if (checkCambia.isSelected()) tendinaCorso.setEnabled(true);
        else if (!checkCambia.isSelected()) tendinaCorso.setEnabled(false);
    }

    private void settaTendina() {
        String[] tabellaCodici =new String[4];

        tabellaCodici[0]= D.getNomeCorso(0);
        tabellaCodici[1]= D.getNomeCorso(1);
        tabellaCodici[2]= D.getNomeCorso(2);
        tabellaCodici[3]="Scegliere...";


        //non separare questi 2 blocchi in 2 metodi separati...
        for (int i =0;i<=3;i++){
            tendinaCorso.addItem(tabellaCodici[i]);
            indiceAncoraDaScegliere = i;
        }

        tendinaCorso.setSelectedIndex(indiceAncoraDaScegliere);
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

}
