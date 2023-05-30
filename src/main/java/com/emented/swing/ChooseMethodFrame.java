package com.emented.swing;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;
import com.emented.math.HalfDivisionMethod;
import com.emented.math.SecantMethod;
import com.emented.math.SimpleIterationMethod;


public class ChooseMethodFrame extends JFrame {
    private JPanel chooseMethodPanel;
    private JRadioButton halfDivisionMethodRadioButton;
    private JRadioButton secantMethodRadioButton;
    private JRadioButton simpleIterationsMethodRadioButton;
    private JButton nextButton;
    private ButtonGroup chooseMethodbuttonGroup;

    public ChooseMethodFrame() {
        setContentPane(chooseMethodPanel);
        setTitle("Method");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        nextButton.addActionListener(e -> {
            if (chooseMethodbuttonGroup.isSelected(halfDivisionMethodRadioButton.getModel())) {
                GlobalStore.method = new HalfDivisionMethod();
            } else if (chooseMethodbuttonGroup.isSelected(secantMethodRadioButton.getModel())) {
                GlobalStore.method = new SecantMethod();
            } else if (chooseMethodbuttonGroup.isSelected(simpleIterationsMethodRadioButton.getModel())) {
                GlobalStore.method = new SimpleIterationMethod();
            }

            OutputTypeFrame outputTypeFrame = new OutputTypeFrame();

            outputTypeFrame.setVisible(true);
            dispose();
        });
    }
}
