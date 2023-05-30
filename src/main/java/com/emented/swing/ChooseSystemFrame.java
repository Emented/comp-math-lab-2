package com.emented.swing;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;
import com.emented.system.FirstSystem;
import com.emented.system.SecondSystem;


public class ChooseSystemFrame extends JFrame {
    private JRadioButton firstSystemRadioButton;
    private JRadioButton secondSystemRadioButton;
    private JButton nextButton;
    private JPanel chooseSystemPanel;
    private ButtonGroup chooseSystemButtonGroup;

    public ChooseSystemFrame() {
        setContentPane(chooseSystemPanel);
        setTitle("System");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        nextButton.addActionListener(e -> {
            if (chooseSystemButtonGroup.isSelected(firstSystemRadioButton.getModel())) {
                GlobalStore.system = new FirstSystem();
            } else if (chooseSystemButtonGroup.isSelected(secondSystemRadioButton.getModel())) {
                GlobalStore.system = new SecondSystem();
            }

            InputStartApproximationFrame inputStartApproximationFrame = new InputStartApproximationFrame();

            inputStartApproximationFrame.setVisible(true);
            dispose();
        });
    }
}
