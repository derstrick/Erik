package b36.gui;

import javafx.scene.paint.Color;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Erik
 * Date: 10.01.14
 * Time: 15:24
 * To change this template use File | Settings | File Templates.
 */
public class ParameterInputVerifier extends InputVerifier {
    @Override
    public boolean verify(JComponent input) {
        JTextField textField = (JTextField) input;
        try {
            if (Integer.valueOf(textField.getText()) < 5 && Integer.valueOf(textField.getText()) > 1){
                return true;
            } else {
                ((JTextField) input).setText("2");
                JOptionPane.showMessageDialog(input, "Nur Werte von 2 bis 4 erlaubt!", "Parameter!", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            // force forward
            return false;
        }
    }
}
