package b36.gui.actionListeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import b36.gui.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: Erik
 * Date: 10.01.14
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */
public class MenuListerner extends Component implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        if ("author".equals(e.getActionCommand())){
            JOptionPane.showMessageDialog(null, Constants.AUTHOR, "Info", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
