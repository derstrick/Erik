package b36.gui.mainframe;

import b36.JobSetup.JobRunner;
import b36.gui.ParameterInputVerifier;
import b36.gui.actionListeners.MenuListerner;
import b36.gui.actionListeners.ParameterButtonListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Erik
 * Date: 10.01.14
 * Time: 13:21
 * To change this template use File | Settings | File Templates.
 */
public class MainView extends JPanel {

    // Constants
    private static MainView mainView;
    GfxPane gfxPane;

    public MainView() {
        JFrame jFrame = new JFrame("Reihenfolgeplanung");
        jFrame.setSize(1000, 500);
        jFrame.setLayout(new BorderLayout());
        jFrame.setJMenuBar(setupMenuBar());
        jFrame.add(new MainPane());

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.pack();
        jFrame.setVisible(true);
        mainView = this;
    }

    public void updateGfXPane(int numberLanes){
        gfxPane.removeAll();
        gfxPane.repaint();
        for (int i = 0; i < numberLanes; i++){
            gfxPane.gbc.gridy++;
            gfxPane.add(new JLabel("Maschine " + (i + 1) + ": "), gfxPane.gbc);
        }
    }

    public class GfxPane extends JPanel {
        GridBagConstraints gbc;
        public GfxPane(){
            setLayout(new GridBagLayout());
            gbc = new GridBagConstraints();
            setBorder(new TitledBorder("Reihenfolgenansicht "));
            setPreferredSize(new Dimension(850,350));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gfxPane = this;
        }
    }

    /**
     * Gets you the instance of this window to alter the values of specific
     * global attributes. For example to alter labels or some text.
     * @return
     */
    public static MainView getInstance() {
        if (MainView.mainView == null) {
            MainView.mainView = new MainView ();
        }
        return MainView.mainView;
    }

    private JMenuBar setupMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.setSize(0, 30);

        // Preferences menu
        JMenu preferencesMenu = new JMenu("Optionen");
        JMenuItem algorithm = new JMenuItem("Algorithmus");
        preferencesMenu.add(algorithm);
        menuBar.add(preferencesMenu);

        // Info menu
        JMenu infoMenu = new JMenu("Info");
        JMenuItem author = new JMenuItem("Autor");
        author.setActionCommand("author");
        author.addActionListener(new MenuListerner());
        infoMenu.add(author);
        menuBar.add(infoMenu);

        return menuBar;
    }

    public class MainPane extends JPanel{
        public MainPane() {

            setLayout(new GridBagLayout());
            GridBagConstraints gbl = new GridBagConstraints();
            gbl.fill = GridBagConstraints.BOTH;
            gbl.gridx = 0;
            gbl.gridy = 0;

            // add parameter pane
            add(new ParameterPane(), gbl);
            // add GfxPane
            gbl.gridy++;
            add(new GfxPane(), gbl);
            gbl.gridy++;
            add(new ResultPane(), gbl);
        }
    }

    public class ParameterPane extends JPanel implements ActionListener{
        JTextField jobAmount;
        JTextField laneAmount;

        private JButton setupParameterPaneButton(){
            JButton paramButton = new JButton();

            paramButton.setActionCommand("start");
            paramButton.setText("Start");
            paramButton.addActionListener(this);
            return paramButton;
        }

        public ParameterPane() {
            ParameterInputVerifier paramVerifyer = new ParameterInputVerifier();

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            setBorder(new TitledBorder("Parameter "));
            setPreferredSize(new Dimension(850,80));
            // label lanes
            JLabel laneLabel = new JLabel();
            laneLabel.setText("Anzahl Maschinen: ");
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridx = 1;
            gbc.gridy = 0;
            add(laneLabel, gbc);

            // textfield lanes
            gbc.gridx++;
            laneAmount = new JTextField();
            laneAmount.setColumns(3);
            laneAmount.setText("2");
            laneAmount.setInputVerifier(paramVerifyer);
            laneAmount.setActionCommand("laneAmount");
            add(laneAmount, gbc);

            // label jobs
            gbc.gridx++;
            JLabel jobLabel = new JLabel();
            jobLabel.setText("Anzahl Jobs: ");
            add(jobLabel, gbc);

            // jobs textfield
            gbc.gridx++;
            jobAmount = new JTextField();
            jobAmount.setColumns(3);
            jobAmount.setText("2");
            jobAmount.setInputVerifier(paramVerifyer);
            jobAmount.setActionCommand("jobAmount");

            add(jobAmount, gbc);

            // add the button
            gbc.gridx++;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.CENTER;
            add(setupParameterPaneButton(), gbc);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if (button.getActionCommand().equals("start")){
                button.setText("Stop");
                button.setActionCommand("stop");
                JobRunner jobRunner = new JobRunner(Integer.valueOf(laneAmount.getText()), Integer.valueOf(jobAmount.getText()));
            } else if (button.getActionCommand().equals("stop")){
                button.setText("Start");
                button.setActionCommand("start");
            }
        }
    }

    public class ResultPane extends JPanel{
        public ResultPane(){
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            setBorder(new TitledBorder("Ergebnis "));
            setPreferredSize(new Dimension(850,150));

            gbc.gridx = 0;
            gbc.gridy = 0;
        }
    }
}
