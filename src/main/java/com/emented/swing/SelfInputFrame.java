package com.emented.swing;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;
import com.emented.dto.BigInterval;


public class SelfInputFrame extends JFrame {

    private JRadioButton inputMyselfRadioButton;
    private JRadioButton calculateIntervalRadioButton;
    private JButton nextButton;
    private JPanel selfInputPanel;
    private ButtonGroup applyIntervalButtonGroup;

    public SelfInputFrame() {
        setContentPane(selfInputPanel);
        setTitle("Input type of interval");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        nextButton.addActionListener(e -> {
            if (applyIntervalButtonGroup.isSelected(inputMyselfRadioButton.getModel())) {
                InputIntervalFrame inputIntervalFrame = new InputIntervalFrame();

                inputIntervalFrame.setVisible(true);
                dispose();
            } else if (applyIntervalButtonGroup.isSelected(calculateIntervalRadioButton.getModel())) {
                GlobalStore.interval = new BigInterval(-5, 5);
                ListIntervalFrame listIntervalFrame = new ListIntervalFrame();

                listIntervalFrame.setVisible(true);
                dispose();
            }
        });
    }
}
