package Librerie.Util;

import javax.swing.*;
import java.awt.*;

/**
 * Creato da Vlady il 17/04/2016.
 * in origine parte del progetto:
 * CircoloTennis
 */
public class UtilityMessages {

    public static void creaDialogErrore(String message, Frame localFrame) {
        JOptionPane.showMessageDialog(localFrame,
                message,
                "Errore",
                JOptionPane.WARNING_MESSAGE);
    }
}
