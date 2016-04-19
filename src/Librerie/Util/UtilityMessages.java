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
			JOptionPane.ERROR_MESSAGE);
}

public static void creaDialogInfo(String message, Frame localFrame) {
	JOptionPane.showMessageDialog(localFrame,
			message,
			"Info",
			JOptionPane.INFORMATION_MESSAGE);
}

public static void creaDialogAttenzione(String message, Frame localFrame) {
	JOptionPane.showMessageDialog(localFrame,
			message,
			"Attenzione",
			JOptionPane.WARNING_MESSAGE);
}


}
