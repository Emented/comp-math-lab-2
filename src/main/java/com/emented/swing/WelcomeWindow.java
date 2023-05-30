package com.emented.swing;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;

public class WelcomeWindow extends JFrame {
    private JRadioButton equationButton;
    private JPanel welcomePanel;
    private JButton nextButton;
    private JLabel chooseField;
    private JLabel headerField;
    private JRadioButton systemButton;
    private ButtonGroup chooseButtonGroup;

    public WelcomeWindow() {
        setContentPane(welcomePanel);
        setTitle("Laboratory work №2");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        nextButton.addActionListener(e -> {
            if (chooseButtonGroup.isSelected(equationButton.getModel())) {
                GlobalStore.isSystem = false;

                ChooseEquationFrame chooseEquationFrame = new ChooseEquationFrame();
                chooseEquationFrame.setVisible(true);

                dispose();
            } else if (chooseButtonGroup.isSelected(systemButton.getModel())) {
                GlobalStore.isSystem = true;

                ChooseSystemFrame chooseSystemFrame = new ChooseSystemFrame();
                chooseSystemFrame.setVisible(true);

                dispose();
            }
        });
    }
}
