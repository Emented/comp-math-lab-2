package com.emented.swing;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;
import com.emented.equation.SecondEquation;
import com.emented.equation.FirstEquation;
import com.emented.equation.ThirdEquation;


public class ChooseEquationFrame extends JFrame {
    private JPanel equationPanel;
    private JRadioButton firstEquationRadioButton;
    private JRadioButton secondEquationRadioButton;
    private JRadioButton thirdEquationRadioButton;
    private JButton nextButton;
    private JLabel chooseEquationLabel;
    private ButtonGroup equationsButtonGroup;

    public ChooseEquationFrame() {
        setContentPane(equationPanel);
        setTitle("Equation");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        nextButton.addActionListener(e -> {

            if (equationsButtonGroup.isSelected(firstEquationRadioButton.getModel())) {
                GlobalStore.equation = new FirstEquation();
            } else if (equationsButtonGroup.isSelected(secondEquationRadioButton.getModel())) {
                GlobalStore.equation = new SecondEquation();
            } else if (equationsButtonGroup.isSelected(thirdEquationRadioButton.getModel())) {
                GlobalStore.equation = new ThirdEquation();
            }

            InputTypeFrame inputTypeFrame = new InputTypeFrame();
            inputTypeFrame.setVisible(true);

            dispose();
        });
    }
}
