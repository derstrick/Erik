package b36.gui.actionListeners;

import b36.JobSetup.JobRunner;
import b36.gui.mainframe.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Erik
 * Date: 10.01.14
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
public class ParameterButtonListener extends MainView implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (button.getActionCommand().equals("start")) {
            button.setText("Stop");
            button.setActionCommand("stop");
//            JobRunner jobRunner = new JobRunner(Integer.valueOf(), Integer.valueOf(lane.getText()) );
        } else if (button.getActionCommand().equals("stop")){
            button.setText("Start");
            button.setActionCommand("start");
        }

    }
}
